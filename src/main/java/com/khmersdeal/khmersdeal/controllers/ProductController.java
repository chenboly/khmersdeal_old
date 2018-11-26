package com.khmersdeal.khmersdeal.controllers;

import com.khmersdeal.khmersdeal.models.ProductDTO;
import com.khmersdeal.khmersdeal.services.ProductService;
import com.khmersdeal.khmersdeal.services.implementations.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${client.path}")
    private String CLIENT_PATH;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //view all product into table (all-products.html)
    @GetMapping("/product/all")
    public String getAllProduct(Model model){
        List<ProductDTO> productDTOList = productService.getAllProduct();
        model.addAttribute("productList", productDTOList);
        return "all-products";
    }
    //view one product once click on view (view-product.html)
    @GetMapping("/product/viewone/{product_id}")
    public String getViewOneProduct(@PathVariable("product_id") Integer id, Model model){
        ProductDTO productDTO = productService.getOneProduct(id);
        model.addAttribute("productID", productDTO);
        return "view-product";
    }

    //go to add new product page (add-product.html)
    @GetMapping("/product/add")
    public String showAddProductForm(Model model){
        //ProductDTO productDTO = new ProductDTO();
        model.addAttribute("addProduct", new ProductDTO());
        return "add-product";
    }
//    //the controller for add form submit button
//    @PostMapping("/product/add/submit")
//    public String submitProductAdded(@Valid ProductDTO productDTO, BindingResult bindingResult, @RequestParam("product-image-file") List<MultipartFile> productImageFile, @RequestParam("productCategories") String productCategoriesFolder){
//        if (bindingResult.hasErrors()){
//            System.out.println("Error occur");
//            return "add-product";
//        }
//        //call upload image class
//        //TODO: write upload image in different class
//        //String fileName = this.fileUploadService.upload(productImageFile, productCategoriesFolder);
//        productDTO.setProductImages(this.fileUploadService.upload(productImageFile, productCategoriesFolder));
//        //add product
//        this.productService.saveProduct(productDTO);
//        return "redirect:/product/all"; //return to product all after save.
//    }

    //the controller for add form submit button
    @PostMapping("/product/add/submit")
    public String submitProductAdded(ProductDTO productDTO, @RequestParam("product-image-file") List<MultipartFile> productImageFile, @RequestParam("productCategories") String productCategoriesFolder){

        //call upload image class
        //TODO: write upload image in different class
        //String fileName = this.fileUploadService.upload(productImageFile, productCategoriesFolder);
        productDTO.setProductImages(this.fileUploadService.upload(productImageFile, productCategoriesFolder));
        //add product
        this.productService.saveProduct(productDTO);
        return "redirect:/product/all"; //return to product all after save.
    }

    //update product controller
    @GetMapping("/product/update/{id}")
    public String showUpdateProductForm(@PathVariable("id") Integer id, Model model){
        ProductDTO productDTO = this.productService.getOneProduct(id);
        model.addAttribute("updateProduct", productDTO);
        return "update-product";
    }

    @PostMapping("/product/update/submit")
    public String submitProductUpdated(ProductDTO productDTO){
        this.productService.updateProduct(productDTO);
        return "redirect:/product/all";

    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        this.productService.deleteProduct(id);
        return "redirect:/product/all";
    }





}

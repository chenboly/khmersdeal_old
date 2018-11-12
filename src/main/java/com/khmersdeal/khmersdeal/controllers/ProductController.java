package com.khmersdeal.khmersdeal.controllers;

import com.khmersdeal.khmersdeal.models.ProductDTO;
import com.khmersdeal.khmersdeal.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

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
        model.addAttribute("addProduct", new ProductDTO());
        return "add-product";
    }




}

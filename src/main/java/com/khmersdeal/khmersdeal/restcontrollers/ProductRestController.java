package com.khmersdeal.khmersdeal.restcontrollers;

import com.khmersdeal.khmersdeal.models.ProductDTO;
import com.khmersdeal.khmersdeal.repositories.ProductRepository;
import com.khmersdeal.khmersdeal.services.ProductService;
import com.khmersdeal.khmersdeal.services.implementations.ProductServiceImplementation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<ProductDTO> getAllProduct(){

        return productService.getAllProduct();

    }

}

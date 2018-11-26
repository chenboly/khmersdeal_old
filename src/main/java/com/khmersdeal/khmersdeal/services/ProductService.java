package com.khmersdeal.khmersdeal.services;

import com.khmersdeal.khmersdeal.models.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct();
    ProductDTO getOneProduct(Integer id);
    boolean saveProduct(ProductDTO productDTO);
    boolean updateProduct(ProductDTO productDTO);
    boolean deleteProduct(Integer id);
}

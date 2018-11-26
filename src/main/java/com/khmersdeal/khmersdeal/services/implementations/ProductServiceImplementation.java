package com.khmersdeal.khmersdeal.services.implementations;

import com.khmersdeal.khmersdeal.models.ProductDTO;
import com.khmersdeal.khmersdeal.repositories.ProductRepository;
import com.khmersdeal.khmersdeal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProduct() {
        return this.productRepository.getAllProduct();
    }

    @Override
    public ProductDTO getOneProduct(Integer id) {
        return this.productRepository.getOneProduct(id);
    }

    @Override
    public boolean saveProduct(ProductDTO productDTO) {
        return this.productRepository.saveNewProduct(productDTO);
    }

    @Override
    public boolean updateProduct(ProductDTO productDTO) {
        return this.productRepository.updateProduct(productDTO);
    }

    @Override
    public boolean deleteProduct(Integer id) {
        return this.productRepository.deleteProduct(id);
    }
}

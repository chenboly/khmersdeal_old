package com.khmersdeal.khmersdeal.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductDTO {
    private Integer id;
    private String ProductName;
    private String ProductDescription;
    private Double ProductPrice;
    private List<String> ProductImages;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String productName, String productDescription, Double productPrice, List<String> productImages) {
        this.id = id;
        ProductName = productName;
        ProductDescription = productDescription;
        ProductPrice = productPrice;
        ProductImages = productImages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public Double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(Double productPrice) {
        ProductPrice = productPrice;
    }

    public List<String> getProductImages() {
        return ProductImages;
    }

    public void setProductImages(List<String> productImages) {
        ProductImages = productImages;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", ProductPrice=" + ProductPrice +
                ", ProductImages=" + ProductImages +
                '}';
    }
}

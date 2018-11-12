package com.khmersdeal.khmersdeal.repositories;

import com.khmersdeal.khmersdeal.models.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    List<ProductDTO> productDTOList = new ArrayList<>();
    {
        productDTOList.add(new ProductDTO(1,"CocaCola", "This is CocaCola",10.5, null));
        productDTOList.add(new ProductDTO(2,"Tiger","This is Tiger" ,20.5, null));
        productDTOList.add(new ProductDTO(3, "ABC","This is ABC" ,30.5, null));
        productDTOList.add(new ProductDTO(4, "RedWine", "This is red wine",40.3, null));
        productDTOList.add(new ProductDTO(5, "Whisky","This is Whisky" ,100.40, null));

    }

    public List<ProductDTO> getAllProduct(){
        return this.productDTOList;
    }
    public ProductDTO getOneProduct(Integer id){
        for (ProductDTO product: productDTOList)
            {
                Integer productID = product.getId();
                if(productID.equals(id)){
                    return product;
                }
            }
        return null;
    }
    public boolean saveNewProduct(ProductDTO productDTO){
        return productDTOList.add(productDTO);
    }

}

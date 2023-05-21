package com.example.productrestapi.service;

import com.example.productrestapi.model.Product;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.productrestapi.repository.ProductRepository;
import java.util.logging.Logger;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private Logger Log = (Logger) LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product getProduct(String id){
        return productRepository.findOne(id);
    }

    public Product saveProduct(Product product) {
        Product productToSave;
        try {
            Log.info("saving product...");
            productToSave = productRepository.save(product);
            return productToSave;
        }
        catch (Exception e)
        {
            Log.info("error occurred during saving of product"+ e.getMessage());
        }
        return new Product();
    }

    public Product updateProduct(Product productToUpdate, String id){
        Product foundProduct;
        foundProduct = productRepository.findOne(id);
        try{
            foundProduct.setName(productToUpdate.getName());
            foundProduct.setDescription(productToUpdate.getDescription());
            foundProduct.setType(productToUpdate.getType());
            foundProduct.setCategory(productToUpdate.getCategory());
            foundProduct.setPrice(productToUpdate.getPrice());
        }
        catch(Exception e)
        {
            Log.info("error occurred during product updating"+ e.getMessage());
        }
        return productToUpdate;
    }

    public void deleteProduct(String id){
        try{
            productRepository.delete(id);
        }
        catch(Exception e){
            Log.info("an error occurred during product deletion"+ e.getMessage());
        }
    }
}

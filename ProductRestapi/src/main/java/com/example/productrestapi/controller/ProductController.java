package com.example.productrestapi.controller;

import com.example.productrestapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.productrestapi.service.ProductService;

@RestController
@RequestMapping(path = "/api/products/")
public class ProductController {

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable(name="id") String id){
        return productService.getProduct(id);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product productToSave){
        return productService.saveProduct(productToSave);
    }
    @RequestMapping(path = "{id}", consumes=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product productToUpdate, @PathVariable(name= "id") String id){
        return productService.updateProduct(productToUpdate ,id);
    }
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name="id") String id){
        productService.deleteProduct(id);
    }



}

package com.example.productrestapi;

import com.example.productrestapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.productrestapi.repository.ProductRepository;

@SpringBootApplication
public class ProductRestapiApplication implements CommandLineRunner {
    private ProductRepository productRepository;

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;}

    public static void main(String[] args) {
        SpringApplication.run(ProductRestapiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product();
        product1.setName("tester product");
        product1.setDescription("tester description");
        product1.setCategory("TEST");
        product1.setType("SPECIFIC");
        product1.setPrice(18.0);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("tester product");
        product2.setDescription("tester description");
        product2.setCategory("TEST");
        product2.setType("GENERAL");
        product2.setPrice(8.0);
        productRepository.save(product2);
    }
}

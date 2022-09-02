package com.rmznbkn.javaspringpracticum.controller;

import com.rmznbkn.javaspringpracticum.repositories.dao.ProductRepository;
import com.rmznbkn.javaspringpracticum.repositories.entities.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product=productRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product){
    productRepository.save(product);
    return ResponseEntity.ok("Product " + product.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductById(@RequestBody Product product,
                                                    @PathVariable Long id){
        if (!product.getId().equals(id)){
            throw new IllegalArgumentException(("Id did not match the data."));
        }
        productRepository.save(product);
        return ResponseEntity.ok("product " + product.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        productRepository.deleteById(id);
        return ResponseEntity.ok("product " + id);
    }

    @GetMapping("/expired")
    public ResponseEntity<List<Product>> getProductsByExpired(){
        List<Product> products=productRepository.findProductsByLastUsableDateLessThan(new Date());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Product>> getProductsByAvailable(){
        List<Product> products = productRepository.findProductsByLastUsableDateGreaterThanOrLastUsableDateIsNull(new Date());
        return ResponseEntity.ok(products);
    }
}

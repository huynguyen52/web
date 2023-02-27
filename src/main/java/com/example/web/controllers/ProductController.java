package com.example.web.controllers;

import com.example.web.models.Product;
import com.example.web.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @PostMapping()
    public Product saveProduct(@RequestBody Product product) {
        return productDAO.save(product);
    }

    @GetMapping()
    public List<Product> getAllProduct() {
        return productDAO.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDAO.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id) {
        return productDAO.deleteProduct(id);
    }
}

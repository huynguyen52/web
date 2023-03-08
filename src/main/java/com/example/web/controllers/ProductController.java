package com.example.web.controllers;

import com.example.web.dto.APIResponse;
import com.example.web.models.Product;
import com.example.web.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping
    public APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = productServices.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productServices.saveProduct(product);
    }

    @GetMapping("/sorting/{field}")
    public APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = productServices.findProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{page}/{size}")
    public Page<Product> getProductsWithPagination(@PathVariable int page, @PathVariable int size) {
        return productServices.getProductsWithPagination(page, size);
    }

    @GetMapping("/paginationwithsort/{page}/{size}/{field}")
    public Page<Product> getProductsWithPaginationWithSort(@PathVariable int page, @PathVariable int size, @PathVariable String field) {
        return productServices.getProductsWithPaginationWithSort(page, size, field);
    }
}

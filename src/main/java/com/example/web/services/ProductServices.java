package com.example.web.services;

import com.example.web.models.Product;
import com.example.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findProductsWithSorting (String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Product> getProductsWithPagination (int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Product> getProductsWithPaginationWithSort (int page, int size, String field) {
        Sort sort = Sort.by(field).descending();
        return productRepository.findAll(PageRequest.of(page, size, sort));
    }
}

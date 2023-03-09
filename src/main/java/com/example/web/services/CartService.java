package com.example.web.services;

import com.example.web.entities.Cart;
import com.example.web.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository repository;

    public Cart save(Cart cart) {
        return repository.save(cart);
    }

    public List<Cart> getCarts() {
        return repository.findAll();
    }
}

package com.example.web.controllers;

import com.example.web.entities.Cart;
import com.example.web.entities.Item;
import com.example.web.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public Cart addToCart() {
        Item item1 = new Item("Item 1");
        Item item2 = new Item("Item 2");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Cart cart = new Cart();
        cart.setItems(items);
        item1.setCart(cart);
        item2.setCart(cart);

        return cartService.save(cart);
    }

    @GetMapping("/")
    public List<Cart> getCart() {
        return cartService.getCarts();
    }

}

package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.entity.Cart;
import com.springmart.springmartbackend.exception.CartNotFoundException;
import com.springmart.springmartbackend.dao.CartRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartServiceImplementation implements CartService {

    private CartRepository cartRepository;

    /**
     * CREATE CART
     */
    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    /**
     * GET ALL CART
     */
    @Override
    public List<Cart> getAllCarts() {
        List<Cart> allCarts = cartRepository.findAll();
        return allCarts;
    }

    /**
     * GET CART
     */
    @Override
    public Cart getCart(Long id) {
        Cart foundCart = cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
        return foundCart;
    }

}

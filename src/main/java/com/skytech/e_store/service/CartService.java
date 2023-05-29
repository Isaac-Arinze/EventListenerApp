package com.skytech.e_store.service;

import com.skytech.e_store.dto.cart.AddToCartDto;
import com.skytech.e_store.dto.cart.CartDto;
import com.skytech.e_store.dto.cart.CartItemDto;
import com.skytech.e_store.exceptions.CartItemNotExistException;
import com.skytech.e_store.model.Cart;
import com.skytech.e_store.model.Product;
import com.skytech.e_store.model.User;
import com.skytech.e_store.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public void addToCart(AddToCartDto addToCartDto, Product product, User user) {
        Cart cart = new Cart(product, user, addToCartDto.getQuantity());
        cartRepository.save(cart);
    }

    public CartDto listCartItems(User user) {
        // first get all the cart items for user
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

        // convert cart to cartItemDto
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = new CartItemDto(cart);
            cartItems.add(cartItemDto);
        }

        // calculate the total price
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += cartItemDto.getProduct().getPrice() * cartItemDto.getQuantity();
        }

        // return cart DTO
        return new CartDto(cartItems,totalCost);
    }

    public void deleteCartItem(int cartItemId, User user) throws CartItemNotExistException {
        //TODO

        // first check if cartItemId is valid else throw an CartItemNotExistException
        // next check if the cartItem belongs to the user else throw CartItemNotExistException exception
        // delete the cart item
    }


}

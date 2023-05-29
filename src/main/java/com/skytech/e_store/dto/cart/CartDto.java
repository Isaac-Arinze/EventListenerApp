package com.skytech.e_store.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
//    List of each item
    private List<CartItemDto> cartItems;
//    Total cost for the cart
    private double totalCost;
}

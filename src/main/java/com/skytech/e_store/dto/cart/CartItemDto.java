package com.skytech.e_store.dto.cart;

import com.skytech.e_store.model.Cart;
import com.skytech.e_store.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemDto {
    private Integer id;
    @NotNull
    private Integer quantity;
    @NotNull
    private Product product;

    public CartItemDto(Cart cart) {
        this.setId(cart.getId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }
}

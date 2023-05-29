package com.skytech.e_store.dto.cart;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Integer id;
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;

}

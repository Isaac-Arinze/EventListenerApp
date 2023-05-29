package com.skytech.e_store.dto;

import com.skytech.e_store.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private  Integer id;
    private @NotNull String name;
    private @NotNull String description;
    private @NotNull Integer categoryId;
    private @NotNull double price;
    private @NotNull String imageURL;

    public ProductDto(@NotNull String name, @NotNull String description, @NotNull Integer categoryId, @NotNull double price, @NotNull String imageURL) {

        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
        this.imageURL = imageURL;
    }
    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setImageURL(product.getImageURL());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setCategoryId(product.getCategory().getId());
    }
}


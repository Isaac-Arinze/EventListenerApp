package com.skytech.e_store.dto.product;

import com.skytech.e_store.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private  Integer id;

    @NotNull
    private  String name;
    @NotNull
    private String description;
    @NotNull
    private Integer categoryId;
    @NotNull
    private  double price;
    @NotNull
    private String imageURL;

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


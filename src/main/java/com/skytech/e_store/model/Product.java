package com.skytech.estore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table (name = "products")
    public class Product {

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Integer id;
        private @NotNull String name;
        private @NotNull String imageURL;
        private @NotNull double price;
        private @NotNull String description;

        @JsonIgnore
        @ManyToOne (fetch = FetchType.LAZY, optional = false)
        @JoinColumn (name = "category_id", nullable = false)

        Category category;

        public Product(String name, String imageURL, double price, String description, Category category) {
            super();
            this.name = name;
            this.imageURL = imageURL;
            this.price = price;
            this.description = description;
        }

    }

package com.skytech.e_store.dto.user;

import com.skytech.e_store.model.Product;
import com.skytech.e_store.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@Data
@Entity
@Table(name="cart")

public class Cart {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="created_date")
    private Date createdDate;

    @ManyToOne
    @Column(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id" )
    private User user;
    private int quantity;

    public Cart(Product product, User user, int quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.createdDate = new Date();
    }

    public Cart() {
    }
}

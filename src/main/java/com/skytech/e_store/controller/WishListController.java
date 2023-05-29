package com.skytech.e_store.controller;

import com.skytech.e_store.common.ApiResponse;
import com.skytech.e_store.dto.product.ProductDto;
import com.skytech.e_store.exceptions.AuthenticationFailException;
import com.skytech.e_store.model.Product;
import com.skytech.e_store.model.User;
import com.skytech.e_store.model.WishList;
import com.skytech.e_store.repository.ProductRepository;
import com.skytech.e_store.service.AuthenticationService;
import com.skytech.e_store.service.WishListService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    private ProductRepository productRepository;

//    API to add a new product in wishlist
    @PostMapping ("/add")
    public ResponseEntity<ApiResponse> addWishList (@RequestBody ProductDto productDto, @RequestParam("token")
                                                    String token) throws AuthenticationFailException {
//        first authenticate if the token is valid
        authenticationService.authenticate(token);
//        then fetch the user linked to the token
        User user = authenticationService.getUser(token);

        Product product = productRepository.getById(productDto.getId());

//        save wishList
        WishList wishList = new WishList(user, product);
        wishListService.createdWishList(wishList);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to wishlist"),
                HttpStatus.CREATED);
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList (@PathVariable("token") String token) throws AuthenticationFailException {
//        first authenticate if the token is valid
        authenticationService.authenticate(token);
//        then fetch the user linked to the token
        User user = authenticationService.getUser(token);
//        First retrieve the wishlist items
        List<WishList> wishLists = wishListService.readWishList(user);

        List<ProductDto> products = new ArrayList<>();
        for (WishList wishList : wishLists) {
//            change each  product to product dto
            products.add(new ProductDto(wishList.getProduct()));
        }
//        send the response to user
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}


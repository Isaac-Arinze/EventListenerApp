package com.skytech.e_store.repository;

import com.skytech.e_store.model.AuthenticationToken;
import com.skytech.e_store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository <AuthenticationToken, String> {

//    Methods for finding token either by user or token
    AuthenticationToken findTokenByUser (User user);
    AuthenticationToken findTokenByToken(String token);
}

package com.skytech.e_store.repository;

import com.skytech.e_store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository <User, Integer> {
    User findByEmail (String email);
}



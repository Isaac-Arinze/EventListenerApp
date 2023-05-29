package com.skytech.estore.repository;

import com.skytech.estore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByCategoryName (String categoryName);
}


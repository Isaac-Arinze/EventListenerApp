package com.skytech.estore.service;

import com.skytech.estore.model.Category;
import com.skytech.estore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category readCategory(String categoryName) {
        return  categoryRepository.findByCategoryName(categoryName);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> readCategory(Integer categoryId) {
        return categoryRepository.findById((categoryId));
    }

    public void updateCategory(Integer categoryID, Category newCategory) {

        Category category1 = categoryRepository.findById(categoryID).get();
        category1.setCategoryName(newCategory.getCategoryName());
        category1.setDescription(newCategory.getDescription());
        category1.setImageUrl(newCategory.getImageUrl());
        categoryRepository.save(category1);

    }
}

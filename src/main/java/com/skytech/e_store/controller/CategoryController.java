package com.skytech.e_store.controller;

import com.skytech.e_store.common.ApiResponse;
import com.skytech.e_store.model.Category;
import com.skytech.e_store.service.CategoryService;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

//    This is to check if the category already exists in the database
    @PostMapping("/create")
    public ResponseEntity <ApiResponse> createCategory (@Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getCategories() {
        List <Category> body = categoryService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

//    This edit category feature will take categoryId and category as the parameters

    @PostMapping("/update/{categoryID}")
    public ResponseEntity <ApiResponse> updateCategory (@PathVariable("categoryID") Integer categoryID,
                                                        @Valid @RequestBody Category category ){
//        Check to see if the categories exists.
        if (Objects.nonNull(categoryService.readCategory(categoryID))) {
//            if the categories exists, then update it
            categoryService.updateCategory(categoryID, category);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.NOT_FOUND);
        }
//            the category doesnt exist then return a response of unsuccessful
        return  new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
        }

    }



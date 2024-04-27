package com.jossegonnza.todolist.service;

import com.jossegonnza.todolist.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryEntity> getAllCategories();
    Optional<CategoryEntity> getCategoryById(Long id);
    List<CategoryEntity> getCategoryByUserId(Long userId);
    void createCategory(CategoryEntity category);
    void updateCategory(Long id, CategoryEntity category);
    void deleteCategoryById(Long id);

}

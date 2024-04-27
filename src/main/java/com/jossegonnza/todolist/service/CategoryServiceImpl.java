package com.jossegonnza.todolist.service;

import com.jossegonnza.todolist.entity.CategoryEntity;
import com.jossegonnza.todolist.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryEntity> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<CategoryEntity> getCategoryByUserId(Long userId) {
        return categoryRepository.findByUserId(userId);
    }

    @Override
    public void createCategory(CategoryEntity category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Long id, CategoryEntity category) {
        CategoryEntity categoryDB = getCategoryById(id).orElseThrow(() -> new InvalidParameterException("Invalid category ID"));
        categoryDB.setName(category.getName());
        categoryDB.setDescription(category.getDescription());
        categoryRepository.save(categoryDB);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}

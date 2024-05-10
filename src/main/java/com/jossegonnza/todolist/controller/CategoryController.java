package com.jossegonnza.todolist.controller;

import com.jossegonnza.todolist.entity.CategoryEntity;
import com.jossegonnza.todolist.service.CategoryService;
import com.jossegonnza.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<CategoryEntity> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/addCategory")
    public void createCategory(@RequestBody CategoryEntity category) {
        categoryService.createCategory(category);
    }

    @PutMapping("/updateCategory")
    public void updateCategory(@RequestBody Long id, CategoryEntity category) {
        categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/deleteCategory")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}

package com.jossegonnza.todolist.controller;

import com.jossegonnza.todolist.entity.CategoryEntity;
import com.jossegonnza.todolist.entity.TaskEntity;
import com.jossegonnza.todolist.entity.UserEntity;
import com.jossegonnza.todolist.service.CategoryService;
import com.jossegonnza.todolist.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "/categories/home";
    }

    @GetMapping("/new")
    public String newCategoryPage() {
        return "/categories/create-category";
    }

    @PostMapping("/create")
    public String createCategory(CategoryEntity category, HttpSession session) {
        UserEntity user = userService.getUserById(Long.parseLong(session.getAttribute("user_session_id").toString())).get();
        category.setUser(user);

        categoryService.createCategory(category);
        return "redirect:/categories/home";
    }

    @GetMapping("/categoryPage/{id}")
    public String categoryPage(@PathVariable Long id, Model model) {
        CategoryEntity category = categoryService.getCategoryById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
        List<TaskEntity> tasks = category.getTasks();

        model.addAttribute("category", category);
        model.addAttribute("tasks", tasks);

        return "/categories/categoryPage";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        CategoryEntity category = categoryService.getCategoryById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
        model.addAttribute("category", category);

        return "/categories/update-category";
    }

    @PostMapping("/update")
    public String updateCategory(@RequestParam("idCategory") Long id, CategoryEntity category) {
        categoryService.updateCategory(id, category);

        return "/categories/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);

        return ("/categories/home");
    }

    @GetMapping("/cancel/{id}")
    public String cancelEditCategory(@PathVariable Long id) {
        CategoryEntity category = categoryService.getCategoryById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        return "redirect/categories/categoryPage";
    }

}

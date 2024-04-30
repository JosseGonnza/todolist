package com.jossegonnza.todolist.controller;

import com.jossegonnza.todolist.entity.CategoryEntity;
import com.jossegonnza.todolist.entity.TaskEntity;
import com.jossegonnza.todolist.entity.UserEntity;
import com.jossegonnza.todolist.service.CategoryService;
import com.jossegonnza.todolist.service.TaskService;
import com.jossegonnza.todolist.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @PostMapping("/addTask")
    public String addTask(@RequestParam("taskId") Long categoryId, TaskEntity task, HttpSession session) {
        UserEntity user = userService.getUserById(Long.parseLong(session.getAttribute("user_session_id").toString())).get();
        CategoryEntity category = categoryService.getCategoryById(categoryId).orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        task.setCreatedAt(LocalDateTime.now());

        taskService.createTask(task);

        return "redirect:/categories/categoryPage";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        TaskEntity task = taskService.getTaskById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));

        model.addAttribute("task", task);

        return "/tasks/update-task";
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam("taskId") Long id, TaskEntity task) {
        TaskEntity taskDB = taskService.getTaskById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));
        taskService.updateTask(id, task);

        return "redirect:/categories/categoryPage" + taskDB.getCategory().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        TaskEntity task = taskService.getTaskById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));
        taskService.deleteTask(id);

        return "redirect:/categories/categoryPage" + task.getCategory().getId();
    }

    @GetMapping("/cancel/{id}")
    public String cancelEditTask(@PathVariable Long id){
        TaskEntity task = taskService.getTaskById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));

        return "redirect:/categories/categoryPage" + task.getCategory().getId();
    }

}

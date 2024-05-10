package com.jossegonnza.todolist.controller;

import com.jossegonnza.todolist.entity.TaskEntity;
import com.jossegonnza.todolist.service.CategoryService;
import com.jossegonnza.todolist.service.TaskService;
import com.jossegonnza.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @PostMapping
    public void createTask(@RequestBody TaskEntity task) {
        taskService.createTask(task);
    }

    @PutMapping
    public void updateTaskById(@RequestBody Long id, TaskEntity task) {
        taskService.updateTask(id, task);
    }

    @DeleteMapping
    public void deleteTaskById(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}

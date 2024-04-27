package com.jossegonnza.todolist.service;

import com.jossegonnza.todolist.entity.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<TaskEntity> getAllTasks();
    Optional<TaskEntity> getTaskById(Long id);
    List<TaskEntity> getTaskByCategoryId(Long categoryId);

    void createTask(TaskEntity task);
    void updateTask(Long id, TaskEntity task);
    void deleteTask(Long id);

}

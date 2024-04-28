package com.jossegonnza.todolist.service;

import com.jossegonnza.todolist.entity.TaskEntity;
import com.jossegonnza.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<TaskEntity> getTaskByCategoryId(Long categoryId) {
        return taskRepository.findByCategoryId(categoryId);
    }

    @Override
    public void createTask(TaskEntity task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Long id, TaskEntity task) {
        TaskEntity taskDB = getTaskById(id).orElseThrow(() -> new InvalidParameterException("Invalid task ID"));
        taskDB.setTitle(task.getTitle());
        taskDB.setContent(task.getContent());
        taskRepository.save(taskDB);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

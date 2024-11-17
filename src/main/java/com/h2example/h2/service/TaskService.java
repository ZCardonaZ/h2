package com.h2example.h2.service;

import com.h2example.h2.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.*;
import com.h2example.h2.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService{

    @Autowired
    private TaskRepository repo;

    public List<Task> getTasks() {
        return (List<Task>) repo.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repo.findById(id);
    }

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = repo.findById(id).orElseThrow();
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setCreationDate(taskDetails.getCreationDate());
        return repo.save(task);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
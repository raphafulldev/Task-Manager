package com.raphabarreto.Task_Manager.service;

import com.raphabarreto.Task_Manager.model.Task;
import com.raphabarreto.Task_Manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public Task update(Long id, Task taskDetails) {
        Task task = findById(id);
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDeadline(taskDetails.getDeadline());
        task.setStatus(taskDetails.getStatus());
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

package dev.wyalves.todolist.services;

import dev.wyalves.todolist.dto.IdResponseDTO;
import dev.wyalves.todolist.dto.TaskRequestDTO;
import dev.wyalves.todolist.dto.TaskResponseDTO;
import dev.wyalves.todolist.models.Task;
import dev.wyalves.todolist.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public IdResponseDTO createTask(TaskRequestDTO request) {
        Task task = new Task();

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status());

        Task newTask = tasksRepository.save(task);
        return new IdResponseDTO(newTask.getId());
    }

    public List<TaskResponseDTO> getAllTasks() {
        return tasksRepository.findAll().stream().map(TaskResponseDTO::new).toList();
    }

    public void updateTask(Long id, TaskRequestDTO request) {
        Task task = tasksRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(String.format("Task #%d not found", id)));

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status());

        tasksRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = tasksRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(String.format("Task #%d not found", id)));

        tasksRepository.delete(task);
    }
}

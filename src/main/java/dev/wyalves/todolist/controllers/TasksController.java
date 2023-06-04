package dev.wyalves.todolist.controllers;

import dev.wyalves.todolist.dto.IdResponseDTO;
import dev.wyalves.todolist.dto.TaskRequestDTO;
import dev.wyalves.todolist.dto.TaskResponseDTO;
import dev.wyalves.todolist.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponseDTO createTask(@RequestBody TaskRequestDTO request) {
        return tasksService.createTask(request);
    }

    @GetMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponseDTO> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO request) {
        tasksService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        tasksService.deleteTask(id);
    }
}

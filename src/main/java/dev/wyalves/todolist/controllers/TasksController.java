package dev.wyalves.todolist.controllers;

import dev.wyalves.todolist.dto.IdResponseDTO;
import dev.wyalves.todolist.dto.TaskRequestDTO;
import dev.wyalves.todolist.dto.TaskResponseDTO;
import dev.wyalves.todolist.services.TasksService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "Tasks API endpoints")
@OpenAPIDefinition(info = @Info(title = "Todo List API", version = "1.0", description = "A simple Todo List API built with Java and Spring Boot."))
public class TasksController {
    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Operation(summary = "Create a new task")
    @ApiResponse(responseCode = "201", description = "Created. Returns the ID of the created task.")
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponseDTO createTask(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Data of the task to be created.")
                                    @RequestBody TaskRequestDTO request) {
        return tasksService.createTask(request);
    }

    @Operation(summary = "Return all tasks")
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponseDTO> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @Operation(summary = "Update an existing task")
    @ApiResponse(responseCode = "204", description = "No Content. It means that the task was successfully updated.")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@Parameter(description = "ID of the task to be updated.") @PathVariable Long id,
                           @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "New task data. All fields must be passed, even if they are not going to be changed.")
                           @RequestBody TaskRequestDTO request) {
        tasksService.updateTask(id, request);
    }

    @Operation(summary = "Delete an existing task")
    @ApiResponse(responseCode = "204", description = "No Content. It means that the task was successfully deleted.")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@Parameter(description = "ID of the task to be deleted.") @PathVariable Long id) {
        tasksService.deleteTask(id);
    }
}

package dev.wyalves.todolist.controllers;

import dev.wyalves.todolist.dto.IdResponseDTO;
import dev.wyalves.todolist.dto.TaskRequestDTO;
import dev.wyalves.todolist.dto.TaskResponseDTO;
import dev.wyalves.todolist.models.Status;
import dev.wyalves.todolist.services.TasksService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("TasksController Unit Tests")
class TasksControllerUnitTest {

    @Test
    @DisplayName("should create task")
    void createTask() {
        // Given
        TaskRequestDTO request = new TaskRequestDTO("Test title", "Test description", Status.TODO);

        TasksService tasksService = mock(TasksService.class);
        when(tasksService.createTask(any(TaskRequestDTO.class))).thenReturn(new IdResponseDTO(1L));

        TasksController tasksController = new TasksController(tasksService);

        // When
        IdResponseDTO response = tasksController.createTask(request);

        // Then
        assertEquals(1L, response.id());
    }

    @Test
    @DisplayName("should get all tasks")
    void getAllTasks() {
        // Given
        TaskResponseDTO task1 = new TaskResponseDTO(1L, "Test title", "Test description", Status.TODO, Instant.now(), Instant.now());
        TaskResponseDTO task2 = new TaskResponseDTO(2L, "Test title", "Test description", Status.TODO, Instant.now(), Instant.now());
        List<TaskResponseDTO> expected = List.of(task1, task2);

        TasksService tasksService = mock(TasksService.class);
        when(tasksService.getAllTasks()).thenReturn(expected);

        TasksController tasksController = new TasksController(tasksService);

        // When
        List<TaskResponseDTO> response = tasksController.getAllTasks();

        // Then
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("should update task")
    void updateTask() {
        // Given
        TaskRequestDTO request = new TaskRequestDTO("Test title", "Test description", Status.TODO);

        TasksService tasksService = mock(TasksService.class);
        doNothing().when(tasksService).updateTask(anyLong(), any(TaskRequestDTO.class));

        TasksController tasksController = new TasksController(tasksService);

        // When
        tasksController.updateTask(1L, request);

        // Then
        verify(tasksService, times(1)).updateTask(1L, request);
    }

    @Test
    @DisplayName("should delete task")
    void deleteTask() {
        // Given
        TasksService tasksService = mock(TasksService.class);
        doNothing().when(tasksService).deleteTask(anyLong());

        TasksController tasksController = new TasksController(tasksService);

        // When
        tasksController.deleteTask(1L);

        // Then
        verify(tasksService, times(1)).deleteTask(1L);
    }

}

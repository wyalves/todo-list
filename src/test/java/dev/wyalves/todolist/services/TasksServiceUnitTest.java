package dev.wyalves.todolist.services;

import dev.wyalves.todolist.dto.IdResponseDTO;
import dev.wyalves.todolist.dto.TaskRequestDTO;
import dev.wyalves.todolist.dto.TaskResponseDTO;
import dev.wyalves.todolist.models.Status;
import dev.wyalves.todolist.models.Task;
import dev.wyalves.todolist.repositories.TasksRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("TasksService Unit Tests")
class TasksServiceUnitTest {

    @Test
    @DisplayName("should create task")
    void createTask() {
        // Given
        TaskRequestDTO request = new TaskRequestDTO("Test title", "Test description", Status.TODO);
        Task task = new Task(null, request.title(), request.description(), request.status(), null, null);
        Task savedTask = new Task(1L, request.title(), request.description(), request.status(), Instant.now(), Instant.now());

        TasksRepository tasksRepository = mock(TasksRepository.class);
        when(tasksRepository.save(task)).thenReturn(savedTask);

        TasksService tasksService = new TasksService(tasksRepository);

        // When
        IdResponseDTO response = tasksService.createTask(request);

        // Then
        assertEquals(1L, response.id());
    }

    @Test
    @DisplayName("should get all tasks")
    void getAllTasks() {
        // Given
        Task task1 = new Task(1L, "Test title", "Test description", Status.TODO, Instant.now(), Instant.now());
        Task task2 = new Task(2L, "Test title", "Test description", Status.TODO, Instant.now(), Instant.now());
        List<TaskResponseDTO> expected = Stream.of(task1, task2).map(TaskResponseDTO::new).toList();

        TasksRepository tasksRepository = mock(TasksRepository.class);
        when(tasksRepository.findAll()).thenReturn(List.of(task1, task2));

        TasksService tasksService = new TasksService(tasksRepository);

        // When
        List<TaskResponseDTO> response = tasksService.getAllTasks();

        // Then
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("should update task")
    void updateTask() {
        // Given
        TaskRequestDTO request = new TaskRequestDTO("Test title", "Test description", Status.TODO);
        Task task = new Task(1L, request.title(), request.description(), request.status(), Instant.now(), Instant.now());

        TasksRepository tasksRepository = mock(TasksRepository.class);
        when(tasksRepository.findById(1L)).thenReturn(Optional.of(task));

        TasksService tasksService = new TasksService(tasksRepository);

        // When
        tasksService.updateTask(1L, request);

        // Then
        verify(tasksRepository, times(1)).save(task);
    }

    @Test
    @DisplayName("should delete task")
    void deleteTask() {
        // Given
        Task task = new Task(1L, "Test title", "Test description", Status.TODO, Instant.now(), Instant.now());

        TasksRepository tasksRepository = mock(TasksRepository.class);
        when(tasksRepository.findById(1L)).thenReturn(Optional.of(task));

        TasksService tasksService = new TasksService(tasksRepository);

        // When
        tasksService.deleteTask(1L);

        // Then
        verify(tasksRepository, times(1)).delete(task);
    }

}

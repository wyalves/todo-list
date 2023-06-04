package dev.wyalves.todolist.dto;

import dev.wyalves.todolist.models.Status;
import dev.wyalves.todolist.models.Task;

import java.time.Instant;

public record TaskResponseDTO(Long id, String title, String description, Status status, Instant createdAt, Instant updatedAt) {

    public TaskResponseDTO(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getCreatedAt(), task.getUpdatedAt());
    }
}

package dev.wyalves.todolist.dto;

import dev.wyalves.todolist.models.Status;
import dev.wyalves.todolist.models.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

@Schema(description = "Response containing all the relevant data of a task. Returned by the GET endpoint.")
public record TaskResponseDTO(@NotBlank Long id, @NotBlank String title, @NotBlank String description, @NotBlank Status status,
                              @NotBlank Instant createdAt, @NotBlank Instant updatedAt) {

    public TaskResponseDTO(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getCreatedAt(), task.getUpdatedAt());
    }
}

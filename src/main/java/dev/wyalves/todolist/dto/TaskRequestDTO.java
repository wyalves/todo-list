package dev.wyalves.todolist.dto;

import dev.wyalves.todolist.models.Status;
import dev.wyalves.todolist.models.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request for creating or updating a task.")
public record TaskRequestDTO(@NotNull String title, @NotNull String description, @NotNull Status status) {
}

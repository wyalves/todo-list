package dev.wyalves.todolist.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "ID of a recently created task. Returned by the POST endpoint.")
public record IdResponseDTO(@NotBlank @Schema(description = "Task ID") Long id) {
}

package dev.wyalves.todolist.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


@Schema(description = "Default error response.")
public record ErrorResponseDTO(@NotBlank @Schema(description = "Error code") int error,
                               @NotBlank @Schema(description = "Error message") String message) {
}

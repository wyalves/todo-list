package dev.wyalves.todolist.dto;

public record IdResponseDTO(Long id) {

    public IdResponseDTO(Long id) {
        this.id = id;
    }
}

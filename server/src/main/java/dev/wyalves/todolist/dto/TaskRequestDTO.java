package dev.wyalves.todolist.dto;

import dev.wyalves.todolist.models.Status;
import dev.wyalves.todolist.models.Task;

public record TaskRequestDTO(String title, String description, Status status) {

    public TaskRequestDTO(Task task) {
        this(task.getTitle(), task.getDescription(), task.getStatus());
    }

}

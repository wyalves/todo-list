package dev.wyalves.todolist.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    TODO("TODO"), DOING("DOING"), DONE("DONE");

    private final String status;
}

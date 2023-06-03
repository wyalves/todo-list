package dev.wyalves.todolist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TasksController {

    @GetMapping(value = {"", "/"})
    public String hello() {
        return "Hello World!";
    }

}

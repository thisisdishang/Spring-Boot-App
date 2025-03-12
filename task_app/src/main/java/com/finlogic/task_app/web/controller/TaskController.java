package com.finlogic.task_app.web.controller;

import com.finlogic.task_app.business.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// @RestController = @Controller + @ResponseBody
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

//    @GetMapping
//    public String getMessage() {
//        return "Hello Spring Boot";
//    }

    @GetMapping
    public List getTasks() {
        return taskService.getTasks();
    }

}

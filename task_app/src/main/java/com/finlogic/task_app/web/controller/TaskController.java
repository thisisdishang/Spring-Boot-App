package com.finlogic.task_app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController = @Controller + @ResponseBody
@RequestMapping("/task")
public class TaskController {

    @GetMapping
    public String getMessage() {
        return "Hello Dishang H. Rana";
    }
}

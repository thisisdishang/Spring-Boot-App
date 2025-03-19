package com.ranacorporation.SpringBootRestAPI.web.controller;

import com.ranacorporation.SpringBootRestAPI.business.service.StudentService;
import com.ranacorporation.SpringBootRestAPI.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable long id) {
        return studentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

}

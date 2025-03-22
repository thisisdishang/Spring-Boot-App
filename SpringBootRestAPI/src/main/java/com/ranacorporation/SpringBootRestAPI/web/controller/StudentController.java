package com.ranacorporation.SpringBootRestAPI.web.controller;

import com.ranacorporation.SpringBootRestAPI.business.service.StudentService;
import com.ranacorporation.SpringBootRestAPI.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> getById(@PathVariable long id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok(Map.of("student", student));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student) {
        Student newStudent = studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("isSuccess", true, "student", student));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Student student) {
        studentService.update(id, student);
        student.setId(id);
        return ResponseEntity.ok(Map.of("isSuccess", true, "student", student));
    }

}

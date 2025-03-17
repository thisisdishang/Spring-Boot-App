package com.ranacorporation.SpringBootRestAPI.web.controller;

import com.ranacorporation.SpringBootRestAPI.business.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
}

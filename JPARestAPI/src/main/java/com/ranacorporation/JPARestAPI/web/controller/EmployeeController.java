package com.ranacorporation.JPARestAPI.web.controller;

import com.ranacorporation.JPARestAPI.business.service.EmployeeService;
import com.ranacorporation.JPARestAPI.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // get all employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully!");
    }

    @PutMapping("/employee/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<?> removeEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee removed successfully!");
    }
}

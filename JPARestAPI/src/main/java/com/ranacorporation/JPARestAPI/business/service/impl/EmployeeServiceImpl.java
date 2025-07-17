package com.ranacorporation.JPARestAPI.business.service.impl;

import com.ranacorporation.JPARestAPI.business.repository.EmployeeRepository;
import com.ranacorporation.JPARestAPI.business.service.EmployeeService;
import com.ranacorporation.JPARestAPI.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee e1 = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        e1.setName(employee.getName());
        e1.setAddress(employee.getAddress());
        e1.setDepartment(employee.getDepartment());
        return employeeRepository.save(e1);
    }

    @Override
    public void removeEmployee(int id) {

    }
}

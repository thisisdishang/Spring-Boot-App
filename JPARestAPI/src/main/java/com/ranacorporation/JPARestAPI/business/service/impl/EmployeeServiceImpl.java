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
        return null;
    }
}

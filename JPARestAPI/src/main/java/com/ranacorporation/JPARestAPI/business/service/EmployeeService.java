package com.ranacorporation.JPARestAPI.business.service;

import com.ranacorporation.JPARestAPI.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployee(int id);

    void createEmployee(Employee employee);

    Employee updateEmployee(Employee employee, int id);
}

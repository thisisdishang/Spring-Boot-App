package com.ranacorporation.JPARestAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_department")
    private String department;
    @Column(name = "emp_address")
    private String address;

    public Employee() {
        // default constructor
    }

    public Employee(String name, String department, String address) {
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" + "empNo=" + empNo + ", name='" + name + '\'' + ", department='" + department + '\'' + ", address='" + address + '\'' + '}';
    }
}

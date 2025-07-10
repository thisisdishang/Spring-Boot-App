package com.ranacorporation.JPARestAPI.business.repository;

import com.ranacorporation.JPARestAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

package com.ranacorporation.SpringBootRestAPI.business.service;

import com.ranacorporation.SpringBootRestAPI.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(long id);

    int save(Student student);

    int update(long id, Student student);

    int delete(long id);
}

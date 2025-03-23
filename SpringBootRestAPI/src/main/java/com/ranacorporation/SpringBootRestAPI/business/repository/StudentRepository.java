package com.ranacorporation.SpringBootRestAPI.business.repository;

import com.ranacorporation.SpringBootRestAPI.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    Student findById(long id);

    Student save(Student student);

    int update(long id, Student student);

    int delete(long id);

    List<Student> getPage(int page, int size);
}

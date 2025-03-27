package com.ranacorporation.SpringBootRestAPI.business.service;

import com.ranacorporation.SpringBootRestAPI.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student getById(long id);

    Student create(Student student);

    void update(long id, Student student);

    void delete(long id);

    List<Student> getPage(int page, int size);

    List<Student> saveAll(List<Student> students);

    int[] deleteAll(List<Integer> ids);

    List<Student> updateStudents(List<Student> students);
}

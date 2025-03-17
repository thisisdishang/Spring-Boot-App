package com.ranacorporation.SpringBootRestAPI.business.repository.impl;

import com.ranacorporation.SpringBootRestAPI.business.repository.StudentRepository;
import com.ranacorporation.SpringBootRestAPI.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student findById(long id) {
        return null;
    }

    @Override
    public int save(Student student) {
        return 0;
    }

    @Override
    public int update(long id, Student student) {
        return 0;
    }

    @Override
    public int delete(long id) {
        return 0;
    }
}

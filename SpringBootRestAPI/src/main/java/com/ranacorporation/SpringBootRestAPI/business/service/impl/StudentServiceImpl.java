package com.ranacorporation.SpringBootRestAPI.business.service.impl;

import com.ranacorporation.SpringBootRestAPI.business.service.StudentService;
import com.ranacorporation.SpringBootRestAPI.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

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

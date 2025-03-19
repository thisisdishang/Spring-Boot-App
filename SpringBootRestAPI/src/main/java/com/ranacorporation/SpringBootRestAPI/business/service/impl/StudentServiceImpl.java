package com.ranacorporation.SpringBootRestAPI.business.service.impl;

import com.ranacorporation.SpringBootRestAPI.business.repository.StudentRepository;
import com.ranacorporation.SpringBootRestAPI.business.service.StudentService;
import com.ranacorporation.SpringBootRestAPI.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
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

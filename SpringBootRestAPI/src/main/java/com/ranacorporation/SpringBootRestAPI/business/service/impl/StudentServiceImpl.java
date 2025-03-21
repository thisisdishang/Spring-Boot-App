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
    public long create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void update(long id, Student student) {
        studentRepository.update(id, student);
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }
}

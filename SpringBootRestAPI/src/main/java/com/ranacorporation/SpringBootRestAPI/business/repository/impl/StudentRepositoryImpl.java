package com.ranacorporation.SpringBootRestAPI.business.repository.impl;

import com.ranacorporation.SpringBootRestAPI.business.repository.StudentRepository;
import com.ranacorporation.SpringBootRestAPI.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Student> studentRowMapper = new RowMapper<>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setId(rs.getLong("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setCourse(rs.getString("course"));
            return s;
        }
    };

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM STUDENTS", studentRowMapper);
    }

    @Override
    public Student findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDENTS WHERE ID=?", studentRowMapper, id);
    }

    @Override
    public int save(Student student) {
        return jdbcTemplate.update("INSERT INTO STUDENTS (NAME, EMAIL, COURSE) VALUES (?, ?, ?)", student.getName(), student.getEmail(), student.getCourse());
    }

    @Override
    public int update(long id, Student student) {
        return jdbcTemplate.update("UPDATE STUDENTS SET NAME=?, EMAIL=?, COURSE=? WHERE ID=?", student.getName(), student.getEmail(), student.getCourse(), id);
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM STUDENTS WHERE ID=?", id);
    }
}

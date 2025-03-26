package com.ranacorporation.SpringBootRestAPI.business.repository.impl;

import com.ranacorporation.SpringBootRestAPI.business.repository.StudentRepository;
import com.ranacorporation.SpringBootRestAPI.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
        return namedParameterJdbcTemplate.query("SELECT * FROM STUDENTS", studentRowMapper);
    }

    @Override
    public Student findById(long id) {
        String query = "SELECT * FROM STUDENTS WHERE ID=:ID";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("ID", id);
        return namedParameterJdbcTemplate.queryForObject(query, params, studentRowMapper);
    }

    @Override
    public Student save(Student student) {
        String query = "INSERT INTO STUDENTS (NAME, EMAIL, COURSE) VALUES (:NAME, :EMAIL, :COURSE)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("NAME", student.getName());
        params.addValue("EMAIL", student.getEmail());
        params.addValue("COURSE", student.getCourse());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(query, params, keyHolder, new String[]{"ID"});

        student.setId(keyHolder.getKey().longValue());
        return student;
    }

    @Override
    public int update(long id, Student student) {
        String query = "UPDATE STUDENTS SET NAME=:NAME, EMAIL=:EMAIL, COURSE=:COURSE WHERE ID=:ID";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("NAME", student.getName())
                .addValue("EMAIL", student.getEmail())
                .addValue("COURSE", student.getCourse())
                .addValue("ID", id);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public int delete(long id) {
        String query = "DELETE FROM STUDENTS WHERE ID=:ID";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("ID", id);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public List<Student> getPage(int page, int size) {
        String query = "SELECT * FROM STUDENTS LIMIT :LIMIT OFFSET :OFFSET";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("LIMIT", size)
                .addValue("OFFSET", page * size);
        return namedParameterJdbcTemplate.query(query, params, studentRowMapper);
    }

    @Override
    public List<Student> saveAll(List<Student> students) {
        String query = "INSERT INTO STUDENTS (NAME, EMAIL, COURSE) VALUES (:NAME, :EMAIL, :COURSE)";
        List<Student> savedStudents = new ArrayList<>();

        for (Student s : students) {
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("NAME", s.getName())
                    .addValue("EMAIL", s.getEmail())
                    .addValue("COURSE", s.getCourse());

            KeyHolder keyHolder = new GeneratedKeyHolder();

            namedParameterJdbcTemplate.update(query, params, keyHolder, new String[]{"ID"});

            s.setId(keyHolder.getKey().intValue());

            savedStudents.add(s);
        }
        return savedStudents;
    }

    @Override
    public int[] deleteAll(List<Integer> ids) {
        String query = "DELETE FROM STUDENTS WHERE ID = :ID";

        MapSqlParameterSource[] batchParams = ids.stream()
                .map(integer -> new MapSqlParameterSource().addValue("ID", integer))
                .toArray(MapSqlParameterSource[]::new);

        return namedParameterJdbcTemplate.batchUpdate(query, batchParams);
    }
}

package com.example.personsys.repository;

import com.example.personsys.domain.Student;
import com.example.personsys.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Student getById(long studentId) {
        String SQL_FOR_ID = "select * from students where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", studentId);

        return jdbcTemplate.queryForObject(SQL_FOR_ID, params, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public List<Student> getAll() {
        String SQL_GET_ALL = "select * from students";
        return jdbcTemplate.query(SQL_GET_ALL, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public void add(Student student) {
        String SQL_FOR_ADD = "insert into students(name, surname, exam) values(:name, :surname, :exam)";

        Map<String, Object> params = new HashMap<>();
        params.put("name", student.getName());
        params.put("surname", student.getSurname());
        params.put("exam", student.getExam());

        jdbcTemplate.execute(SQL_FOR_ADD, params, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public void delete(long studentId) {
        String SQL_FOR_DELETE = "delete from students where id=:id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", studentId);

        jdbcTemplate.update(SQL_FOR_DELETE, params);
    }

    @Override
    public void updateById(StudentDto studentDto) {
        String SQL_FOR_UPDATE = "update students set id=:id, name=:name, surname=:surname, exam=:exam where id=:id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", studentDto.getId());
        params.put("name", studentDto.getName());
        params.put("surname", studentDto.getSurname());
        params.put("exam", studentDto.getExam());

        jdbcTemplate.update(SQL_FOR_UPDATE, params);
    }

}

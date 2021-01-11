package com.example.personsys.repository;

import com.example.personsys.domain.Teacher;
import com.example.personsys.dto.TeacherDto;
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
public class TeacherRepositoryImpl implements TeacherRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Teacher getById(long teacherId) {
        String SQL_FOR_ID = "select * from teachers where id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", teacherId);

        return jdbcTemplate.queryForObject(SQL_FOR_ID, params, new BeanPropertyRowMapper<>(Teacher.class));
    }

//    private static final class TeacherRowMapper implements RowMapper<Teacher> {
//
//        @Override
//        public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Teacher teacher = new Teacher(
//                    rs.getLong("id"),
//                    rs.getString("name"),
//                    rs.getString("surname"),
//                    rs.getString("subject")
//            );
//            return teacher;
//        }
//    }

    @Override
    public List<Teacher> findAll() {
        String SQL_FIND_ALL = "select * from teachers";
        return jdbcTemplate.query(SQL_FIND_ALL, new BeanPropertyRowMapper<>(Teacher.class));
    }

    @Override
    public void add(Teacher teacher) {
        String SQL_FOR_ADD = "insert into teachers(name, surname, subject) values(:name, :surname, :subject)";

        Map<String, Object> params = new HashMap<>();
        params.put("name", teacher.getName());
        params.put("surname", teacher.getSurname());
        params.put("subject", teacher.getSubject());

        jdbcTemplate.execute(SQL_FOR_ADD, params, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public void delete(long teacherId) {
        String SQL_FOR_DELETE = "delete from teachers where id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", teacherId);

        jdbcTemplate.update(SQL_FOR_DELETE, params);
    }

    @Override
    public void updateById(TeacherDto teacherDto) {
        String SQL_FOR_UPDATE = "update teachers set id=:id, name=:name, surname=:surname, subject=:subject where id=:id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", teacherDto.getId());
        params.put("name", teacherDto.getName());
        params.put("surname", teacherDto.getSurname());
        params.put("subject", teacherDto.getSubject());

        jdbcTemplate.update(SQL_FOR_UPDATE, params);
    }

}

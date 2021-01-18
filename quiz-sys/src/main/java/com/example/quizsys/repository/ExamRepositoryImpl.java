package com.example.quizsys.repository;

import com.example.quizsys.domain.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ExamRepositoryImpl implements ExamRepository{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Exam> getAllExamDates(long count) {

        String SQL_FIND_ALL = "select * from exam limit :count";

        Map<String, Object> params = new HashMap<>();
        params.put("count", count);

        return jdbcTemplate.query(SQL_FIND_ALL, params, new BeanPropertyRowMapper<>(Exam.class));

    }

    @Override
    public void assignExam(Exam exam) {

        String SQL_FOR_DATE = "insert into exam(exam_date, exam_expiration_date, location) " +
                " values(:exam_date, :exam_expiration_date, :location)";

        Map<String, Object> params = new HashMap<>();
        params.put("exam_date", exam.getExamDate());
        params.put("exam_expiration_date", exam.getExamExpirationDate());
        params.put("location", exam.getLocation());

        jdbcTemplate.update(SQL_FOR_DATE, params);
    }

}

package com.example.msexam.repository;

import com.example.msexam.client.clientExam.model.ExamClientResponse;
import com.example.msexam.client.clientStudent.model.StudentClientResponse;
import com.example.msexam.domain.Exam;
import com.example.msexam.dto.ExamersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ExamTimingRepositoryImpl implements ExamTimingRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<ExamersDto> getAllExamDates(long count) {

        String SQL_FIND_ALL = "select * from real_exams limit :count";

        Map<String, Object> params = new HashMap<>();
        params.put("count", count);

        return jdbcTemplate.query(SQL_FIND_ALL, params, new BeanPropertyRowMapper<>(ExamersDto.class));

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

    @Override
    public void setExamForStudent(ExamClientResponse examClientResponse,
                                  StudentClientResponse studentClientResponse) {

        String SQL_FOR_ADD = "insert into real_exams(name, surname, exam, exam_date, exam_expiration_date, location) " +
                " values ( " +
                " :name, " +
                " :surname, " +
                " :exam, " +
                " :exam_date, " +
                " :exam_expiration_date, " +
                " :location) ";

        Map<String, Object> params = new HashMap<>();
        params.put("name", studentClientResponse.getName());
        params.put("surname", studentClientResponse.getSurname());
        params.put("exam", studentClientResponse.getExam());
        params.put("exam_date", examClientResponse.getExamDate());
        params.put("exam_expiration_date", examClientResponse.getExamExpirationDate());
        params.put("location", examClientResponse.getLocation());

        jdbcTemplate.update(SQL_FOR_ADD, params);
    }

}

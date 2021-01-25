package com.example.msquiz.repository;

import com.example.msquiz.domain.Answers;
import com.example.msquiz.domain.Questions;
import com.example.msquiz.domain.TrueAnswers;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AnswersRepositoryImpl implements AnswersRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<TrueAnswers> getTrueAnswersByQuestionsIDs(List<Questions> questions) {
        String SQL_FOR_TRUE_ANSWERS = "select * from true_answer where true_answer =:id";

        Map<String, Object> params = new HashMap<>();

        int index = 0;
        while (index < questions.size()) {
            params.put("id", questions.indexOf(index));
        }

        return jdbcTemplate.query(SQL_FOR_TRUE_ANSWERS, params, new BeanPropertyRowMapper<>(TrueAnswers.class));
    }

}

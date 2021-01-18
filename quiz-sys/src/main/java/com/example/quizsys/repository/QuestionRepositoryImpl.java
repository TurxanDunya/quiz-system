package com.example.quizsys.repository;

import com.example.quizsys.domain.Answers;
import com.example.quizsys.domain.Questions;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Answers> getAnswerByQuestionId(long id) {
        String SQL_FOR_ANSWER = "select * from answers where question_id=:id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return jdbcTemplate.query(SQL_FOR_ANSWER, params, new BeanPropertyRowMapper<>(Answers.class));
    }

    @Override
    public List<Questions> findByType(int type) {
        String SQL_FOR_ID = "select * from questions where type = :type";

        Map<String, Object> params = new HashMap<>();
        params.put("type", type);

        return jdbcTemplate.query(SQL_FOR_ID, params, new BeanPropertyRowMapper<>(Questions.class));
    }

    @Override
    public void add(Questions questions) {
        String SQL_FOR_ADD = "insert into questions(question, subject, type) values(:question, :subject, :type)";

        StringBuilder subject = new StringBuilder("");
        if (questions.getType() == 1) {
            subject.append("Philosophy");
        } else if (questions.getType() == 2) {
            subject.append("Mathematics");
        } else if (questions.getType() == 3) {
            subject.append("Literature");
        } else {
            subject.append("Software Engineering");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("question", questions.getQuestion());
        params.put("subject", subject);
        params.put("type", questions.getType());

        jdbcTemplate.update(SQL_FOR_ADD, params);
    }

    @Override
    public void delete(long questionId) {
        String SQL_FOR_DELETE = "delete from questions where id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", questionId);

        jdbcTemplate.update(SQL_FOR_DELETE, params);
    }

    @Override
    public void updateById(Questions questions) {
        String SQL_FOR_UPDATE = "update questions set id=:id, question=:question where id=:id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", questions.getQuestion());

        jdbcTemplate.update(SQL_FOR_UPDATE, params);
    }

}

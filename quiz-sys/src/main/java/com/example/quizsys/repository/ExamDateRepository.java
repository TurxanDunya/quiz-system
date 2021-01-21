package com.example.quizsys.repository;

import com.example.quizsys.dto.ExamersDto;
import com.example.usersys.client.clientExam.model.ExamClientResponse;
import com.example.usersys.client.clientStudent.model.StudentClientResponse;

import java.util.List;

public interface ExamDateRepository {

    List<ExamersDto> getAllExamDates(long count);

    void setExamForStudent(ExamClientResponse examClientResponse,
                          StudentClientResponse studentClientResponse);
}

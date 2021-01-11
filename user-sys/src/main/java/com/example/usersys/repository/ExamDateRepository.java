package com.example.usersys.repository;

import com.example.usersys.client.clientExam.model.ExamClientResponse;
import com.example.usersys.client.clientStudent.model.StudentClientResponse;
import com.example.usersys.dto.ExamersDto;

import java.util.List;

public interface ExamDateRepository {

    List<ExamersDto> getAllExamDates(long count);

    void setExamForStudent(ExamClientResponse examClientResponse,
                          StudentClientResponse studentClientResponse);
}

package com.example.quizsys.service;

import com.example.quizsys.domain.RealExam;
import com.example.quizsys.dto.ExamersDto;
import com.example.usersys.client.FeignClientExam;
import com.example.usersys.client.FeignClientStudent;
import com.example.usersys.client.clientExam.model.ExamClientRequest;
import com.example.usersys.client.clientExam.model.ExamClientResponse;
import com.example.usersys.client.clientStudent.model.StudentClientResponse;
import com.example.usersys.domain.RealExam;
import com.example.usersys.dto.ExamersDto;
import com.example.usersys.repository.ExamDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamDatesServiceImpl implements ExamDatesService {

    private final FeignClientExam clientExam;
    private final FeignClientStudent clientStudent;
    private final ExamDateRepository examDateRepository;

    @Override
    public List<ExamersDto> getAllExamDates(long count) {
        return examDateRepository.getAllExamDates(count);
    }

    @Override
    public void setManualExamForStudent(RealExam exam) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(exam.getExamDate().toString(), formatter);

        ExamClientRequest examClientRequest = new ExamClientRequest();
        examClientRequest.setExamDate(time);
        examClientRequest.setLocation(exam.getLocation());

        ExamClientResponse examClientResponse = clientExam.assignManualExam(examClientRequest);
        StudentClientResponse studentById = clientStudent.getById(exam.getId());

        examDateRepository.setExamForStudent(examClientResponse, studentById);
    }

    @Override
    public void setRandomExamForStudent(long id) {

        ExamClientResponse examClientResponse = clientExam.assignRandomExam();
        StudentClientResponse studentById = clientStudent.getById(id);

        examDateRepository.setExamForStudent(examClientResponse, studentById);
    }

}

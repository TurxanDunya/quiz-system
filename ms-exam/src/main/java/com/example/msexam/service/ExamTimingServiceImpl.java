package com.example.msexam.service;

import com.example.msexam.client.FeignClientExam;
import com.example.msexam.client.FeignClientStudent;
import com.example.msexam.client.clientExam.model.ExamClientRequest;
import com.example.msexam.client.clientExam.model.ExamClientResponse;
import com.example.msexam.client.clientStudent.model.StudentClientResponse;
import com.example.msexam.domain.Exam;
import com.example.msexam.domain.RealExam;
import com.example.msexam.dto.ExamDto;
import com.example.msexam.dto.ExamersDto;
import com.example.msexam.mapper.ExamMapper;
import com.example.msexam.repository.ExamTimingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ExamTimingServiceImpl implements ExamTimingService {

    private final ExamTimingRepository examRepository;
    private final ExamMapper examMapper;
    private final FeignClientExam clientExam;
    private final FeignClientStudent clientStudent;

    @Override
    public List<ExamersDto> getAllExamDates(long count) {
        return examMapper.toExamersDtos(examRepository.getAllExamDates(count));
    }

    @Override
    public ExamDto assignRandomExam() {

        Random r = new Random();
        LocalDateTime dateTime = LocalDateTime.now();

        ExamDto examDto = new ExamDto();
        examDto.setExamDate(dateTime);
        examDto.setLocation(r.nextInt(300) + " sayli merkez");
        examDto.setExamExpirationDate(dateTime.plusMinutes(90L));

        examRepository.assignExam(examMapper.toDomain(examDto));
        return examDto;
    }

    @Override
    public ExamDto assignManualExam(Exam exam) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(exam.getExamDate().toString(), formatter);

        ExamDto examDto = new ExamDto();
        examDto.setExamDate(time);
        examDto.setLocation(exam.getLocation());

        LocalDateTime localDateTime = examDto.getExamDate();
        examDto.setExamExpirationDate(localDateTime.plusMinutes(90L));

        examRepository.assignExam(examMapper.toDomain(examDto));
        return examDto;
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

        examRepository.setExamForStudent(examClientResponse, studentById);
    }

    @Override
    public void setRandomExamForStudent(long id) {

        ExamClientResponse examClientResponse = clientExam.assignRandomExam();
        StudentClientResponse studentById = clientStudent.getById(id);

        examRepository.setExamForStudent(examClientResponse, studentById);
    }

}

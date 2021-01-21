package com.example.quizsys.service;

import com.example.quizsys.client.FeignClientStudent;
import com.example.quizsys.client.clientStudent.model.StudentClientResponse;
import com.example.quizsys.domain.Exam;
import com.example.quizsys.domain.RealExam;
import com.example.quizsys.dto.ExamDto;
import com.example.quizsys.dto.ExamersDto;
import com.example.quizsys.mapper.ExamMapper;
import com.example.quizsys.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService{

    private final ExamRepository examRepository;
    private final ExamMapper examMapper;
    private final FeignClientStudent clientStudent;

    @Override
    public List<ExamersDto> getAllExamDates(long count) {
        return examMapper.toExamersDtos(examRepository.getAllExamDates(count));
    }

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

        Exam examClient = new Exam();
        examClient.setExamDate(time);
        examClient.setLocation(exam.getLocation());

        ExamDto examManual = assignManualExam(examClient);
        StudentClientResponse studentById = clientStudent.getById(exam.getId());

        examRepository.setExamForStudent(examManual, studentById);
    }

    @Override
    public void setRandomExamForStudent(long id) {

        ExamDto examRandom = assignRandomExam();
        StudentClientResponse studentById = clientStudent.getById(id);

        examRepository.setExamForStudent(examRandom, studentById);

    }

}

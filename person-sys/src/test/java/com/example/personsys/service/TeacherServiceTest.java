package com.example.personsys.service;

import com.example.personsys.domain.Teacher;
import com.example.personsys.dto.TeacherDto;
import com.example.personsys.mapper.TeacherMapper;
import com.example.personsys.repository.TeacherRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @Mock
    private TeacherRepositoryImpl teacherRepository;

    @Mock
    private TeacherMapper teacherMapper;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @BeforeAll
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUsersTest() {

        List<Teacher> givenTeacherDtoList = List.of(Teacher.builder()
                .id(1L)
                .name("Test-Name")
                .surname("Test-Surname")
                .subject("Test-Subject")
                .build());

        List<TeacherDto> expectedTeacherDtoList = List.of(TeacherDto.builder()
                .id(1L)
                .name("Test-Name")
                .surname("Test-Surname")
                .subject("Test-Subject")
                .build());

        Mockito.when(teacherMapper.toTeacherDtos(givenTeacherDtoList)).thenReturn(expectedTeacherDtoList);

        Mockito.when(teacherRepository.findAll()).thenReturn(Stream
                .of(new Teacher(1L, "Test-Name", "Test-Surname", "Test-Subject"),
                        new Teacher(2L, "Test-Name-2", "Test-Surname-2", "Test-Subject-2"))
                .collect(Collectors.toList()));

        Assertions.assertEquals(2, teacherService.getAll().size());

    }

    @Test
    public void shouldDelete() {
        Teacher teacher = new Teacher(1L, "Test-Name", "Test-Surname", "Test-Subject");
        teacherService.delete(1L);

        Mockito.verify(teacherRepository, Mockito.times(1)).delete(1);
    }

}

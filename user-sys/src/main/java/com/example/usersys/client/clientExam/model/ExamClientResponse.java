package com.example.usersys.client.clientExam.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamClientResponse {

    private LocalDateTime examDate;

    private LocalDateTime examExpirationDate;

    private String location;

}

package com.example.msexam.client.clientQuestion.model;

import lombok.Data;

import java.util.List;

@Data
public class QuestionClientRequest {

    private Long id;

    private String question;

    private String subject;

    private int type;

    private int level;

    private List<Answers> answers;

}

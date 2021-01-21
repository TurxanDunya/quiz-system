package com.example.msexam.client.model;

import lombok.Data;

@Data
public class QuestionClientResponse {

    private long id;

    private String question;

    private String subject;

    private int type;

}

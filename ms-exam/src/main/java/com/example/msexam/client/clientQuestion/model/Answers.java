package com.example.msexam.client.clientQuestion.model;

import lombok.Data;

@Data
public class Answers {

    private int type;

    private int questionID;

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answerE;

}

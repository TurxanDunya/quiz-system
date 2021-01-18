package com.example.quizsys.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answers {

    private int type;

    private int questionID;

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answerE;

}

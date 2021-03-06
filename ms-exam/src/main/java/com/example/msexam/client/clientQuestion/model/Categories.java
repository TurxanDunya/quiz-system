package com.example.msexam.client.clientQuestion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Categories {

    private int type;

    private int low;
    private int normal;
    private int hard;

}

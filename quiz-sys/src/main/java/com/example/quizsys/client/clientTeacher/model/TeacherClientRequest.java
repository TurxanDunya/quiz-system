package com.example.quizsys.client.clientTeacher.model;

import lombok.Data;

@Data
public class TeacherClientRequest {

    private long id;

    private String name;

    private String surname;

    private String subject;

}
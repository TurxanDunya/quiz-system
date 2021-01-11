package com.example.usersys.client.clientStudent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentClientResponse {

    private long id;

    private String name;

    private String surname;

    private String exam;

}

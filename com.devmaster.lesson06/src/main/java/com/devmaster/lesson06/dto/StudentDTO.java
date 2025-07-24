package com.devmaster.lesson06.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private String email;
    private int age;
}

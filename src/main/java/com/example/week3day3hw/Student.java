package com.example.week3day3hw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data @Entity
@NoArgsConstructor
public class Student {
    @Id
    @NotNull(message = "ID cant be null")
    private Integer id;
    @NotEmpty(message = "name cant be empty")
    private String name;
    @NotEmpty(message = "age cant be empty")
    private String age;
    @NotEmpty(message = "major cant be empty")
    private String major;



    }


package com.example.Task01.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestModel {

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 50)
    private String fName;

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 50)
    private String lName;

    @NotNull
    @NotBlank
    private int age;

    @NotNull
    @NotBlank
    private int telNo;

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 50)
    private String department;
}

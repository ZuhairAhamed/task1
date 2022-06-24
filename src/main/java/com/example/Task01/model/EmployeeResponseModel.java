package com.example.Task01.model;

import com.example.Task01.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModel {

    private int id;

    private String fName;

    private String lName;

    private String exception;

    public EmployeeResponseModel(Employee savedEmployee) {
        setId(savedEmployee.getId());
        setFName(savedEmployee.getFName());
        setLName(savedEmployee.getLName());
    }

    @Autowired
    public EmployeeResponseModel(String exception){
        this.exception=exception;
    }


}

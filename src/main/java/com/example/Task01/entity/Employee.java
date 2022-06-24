package com.example.Task01.entity;

import com.example.Task01.model.EmployeeRequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotBlank
    private int id;

    @Column(name = "FName")
    @NotBlank
    @Size(min = 0, max = 50)
    private String fName;

    @Column(name="LName")
    @NotBlank
    @Size(min = 0, max = 50)
    private String lName;

    @Column(name="Age")
    @NotBlank
    private int age;

    @Column(name="TelNo")
    @NotBlank
    private int telNo;

    @Column(name = "Department")
    @NotBlank
    @Size(min = 0, max = 50)
    private String department;


    public Employee(EmployeeRequestModel employeeRequestModel) {
        setFName(employeeRequestModel.getFName());
        setLName(employeeRequestModel.getLName());
        setAge(employeeRequestModel.getAge());
        setTelNo(employeeRequestModel.getTelNo());
        setDepartment(employeeRequestModel.getDepartment());
    }
}

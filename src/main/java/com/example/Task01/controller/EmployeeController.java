package com.example.Task01.controller;

import com.example.Task01.model.EmployeeRequestModel;
import com.example.Task01.model.EmployeeResponseModel;
import com.example.Task01.service.EmployeeService;
import com.example.Task01.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/employee")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Operation(summary = "Add an employee to the DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee added successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "Data provided is invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "DB or table not found",
                    content = @Content) })
    @PostMapping("/addEmployee")
    public EmployeeResponseModel addEmp(@RequestBody EmployeeRequestModel employeeRequestModel){
        return service.add(employeeRequestModel);
    }

    @Operation(summary = "Get all the employees from DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All employee details are retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "URL is invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "DB or table not found",
                    content = @Content) })
    @GetMapping("/getEmployees")
    public List<EmployeeResponseModel> getAllEmp(){
        return service.getAll();
    }

    @Operation(summary = "Get employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee is retrieved by the ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "500", description = "ID is invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee table not found",
                    content = @Content) })
    @GetMapping("/getEmployeeById/{id}")
    public EmployeeResponseModel getEmpById(@Parameter(description = "id of employee to be searched")
                                                @PathVariable int id){
        return service.getById(id);
    }

    @Operation(summary = "Delete employee by the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "500", description = "ID provided is invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "DB or table not found",
                    content = @Content) })
    @DeleteMapping("/deleteEmployee/{id}")
    public EmployeeResponseModel deleteEmp(@Parameter(description = "id of employee to be deleted")
                                               @PathVariable("id") int id){
        return service.delete(id);
    }

    @Operation(summary = "Update an employee by the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "500", description = "ID provided is invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "DB or table not found",
                    content = @Content) })
    @PutMapping("/updateEmployee/{id}")
    public EmployeeResponseModel updateEmp(@Parameter(description = "id of employee to be updated")
                                               @PathVariable("id")int id,
                              @RequestBody EmployeeRequestModel erm){
        return service.update(id,erm);
    }
}

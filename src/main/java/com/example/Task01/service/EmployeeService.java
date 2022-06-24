package com.example.Task01.service;

import com.example.Task01.entity.Employee;
//import com.example.Task01.exceptionhandler.EmployeeResponseExceptionHandler;
import com.example.Task01.exceptionhandler.EmployeeResponseExceptionHandler;
import com.example.Task01.model.EmployeeRequestModel;
import com.example.Task01.model.EmployeeResponseModel;
import com.example.Task01.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    private EmployeeRepo repo;
    private EmployeeResponseExceptionHandler exceptionHandler;

    @Autowired
    public EmployeeService(EmployeeRepo repo){
        this.repo=repo;
    }

    public EmployeeResponseModel add(EmployeeRequestModel employeeRequestModel){
        Employee newEmployee = new Employee(employeeRequestModel);
        Employee savedEmployee =  repo.save(newEmployee);
        return new EmployeeResponseModel(savedEmployee);
    }

    public List<EmployeeResponseModel> getAll(){
        List<Employee> employees = repo.findAll();

        List<EmployeeResponseModel> employeeResponseModelList = new ArrayList<>();
        for (Employee employee: employees) {
            EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel(employee);
            employeeResponseModelList.add(employeeResponseModel);
        }

        return employeeResponseModelList;
    }

    public EmployeeResponseModel getById(int id){
        Optional<Employee> employee=repo.findById(id);
        if (employee.isPresent()) {
            return new EmployeeResponseModel(employee.get());
        }
        else{
            return exceptionHandler.idNotFound();
        }
    }

    public EmployeeResponseModel delete(int id){
        Optional<Employee> employee=repo.findById(id);
        if(employee.isPresent()){
            repo.delete(employee.get());
            return new EmployeeResponseModel(employee.get());
        }
        else{
            return exceptionHandler.idNotFound();
        }
    }




    public EmployeeResponseModel update(int id,EmployeeRequestModel employeeRequestModel){
        Optional<Employee> employee=repo.findById(id);
        if(employee.isPresent()) {
            employee.get().setFName(employeeRequestModel.getFName());
            employee.get().setLName(employeeRequestModel.getLName());
            employee.get().setAge(employeeRequestModel.getAge());
            employee.get().setTelNo(employeeRequestModel.getTelNo());
            employee.get().setDepartment(employeeRequestModel.getDepartment());
            Employee updatedEmployee = repo.save(employee.get());
            return new EmployeeResponseModel(updatedEmployee);
        }
        else{
            return exceptionHandler.idNotFound();
        }
    }


}

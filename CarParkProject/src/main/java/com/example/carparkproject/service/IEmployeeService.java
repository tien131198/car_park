package com.example.carpark.service;

import com.example.carpark.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IEmployeeService {
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee, long idEmployee);
    public void delete(long employeeId);
    public Page<Employee> findAll(String sort, int page, int limit);

}

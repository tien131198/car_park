package com.example.carpark.service;

import com.example.carpark.entity.Employee;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, long idEmployee) {
        Employee e = employeeRepository.findById(idEmployee).orElse(null);
        if (e == null) {
            throw new NotFoundException();
        } else {
            e.setEmployeeAddress(employee.getEmployeeAddress());
            e.setEmployeeEmail(employee.getEmployeeEmail());
            e.setEmployeeName(employee.getEmployeeName());
            e.setAccount(employee.getAccount());
            e.setEmployeePassword(employee.getEmployeePassword());
            e.setEmployeePhone(employee.getEmployeePhone());
            e.setDepartment(employee.getDepartment());
            e.setEmployeeBirthDay(employee.getEmployeeBirthDay());
            e.setSex(employee.getSex());
            employeeRepository.save(e);
        }
        return e;
    }

    @Override
    public void delete(long employeeId) {
        Employee e = employeeRepository.findById(employeeId).orElse(null);
        if (e == null) {
            throw new NotFoundException();
        } else {
            employeeRepository.deleteById(employeeId);
        }
    }
    @Override
    public Page<Employee> findAll(String sort, int page, int limit) {
        Sort sortable = null;
        if (sort.equals("asc")) {
            sortable = Sort.by("employeeName").ascending();
        }
        if (sort.equals("desc")) {
            sortable = Sort.by("employeeName").descending();
        }
        Pageable pageable = PageRequest.of(page, limit, sortable);
        return employeeRepository.findAll(pageable);
    }
}

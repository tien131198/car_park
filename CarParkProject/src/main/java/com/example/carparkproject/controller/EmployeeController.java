package com.example.carpark.controller;

import com.example.carpark.entity.Employee;
import com.example.carpark.output.OutPut;
import com.example.carpark.service.EmployeeService;
import com.example.carpark.service.IEmployeeService;
import jakarta.websocket.server.PathParam;
import org.hibernate.result.internal.OutputsImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.TimeoutDeferredResultProcessingInterceptor;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeemanagement/employeelist")
public class EmployeeController {
    private IEmployeeService iEmployeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.iEmployeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        iEmployeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") int id,
                                   @RequestBody Employee employee) {
        return iEmployeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        iEmployeeService.delete(id);
        return "Delete thanh cong";
    }


    @GetMapping("/views")
    public Page<Employee> getAll(@PathParam("page") int page,
                                 @PathParam("sort") String sort,
                                 @PathParam("limit") int limit) {
        Page<Employee> employeePage = iEmployeeService.findAll(sort, page, limit);
        return employeePage;
    }
    @GetMapping(value = "/test", params = "delete")
    public String toDo(@RequestParam("name") String name ){
        return "oki"+ name;
    }
}

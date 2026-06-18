package com.shreyasi.employee.controller;

import com.shreyasi.employee.model.Employee;
import com.shreyasi.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable String id,
            @RequestBody Employee employee) {

        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable String id) {

        service.deleteEmployee(id);

        return "Employee Deleted Successfully";
    }
}
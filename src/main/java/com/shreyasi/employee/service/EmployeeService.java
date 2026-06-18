package com.shreyasi.employee.service;

import com.shreyasi.employee.model.Employee;
import com.shreyasi.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Employee updateEmployee(String id, Employee employee) {

        Employee existing =
                repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setName(employee.getName());
            existing.setDepartment(employee.getDepartment());
            existing.setSalary(employee.getSalary());
            existing.setEmail(employee.getEmail());

            return repository.save(existing);
        }

        return null;
    }

    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }
}
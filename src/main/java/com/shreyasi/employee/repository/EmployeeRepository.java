package com.shreyasi.employee.repository;

import com.shreyasi.employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends MongoRepository<Employee, String> {

}
package com.example.myapp.repository;

import com.example.myapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Additional custom methods can be defined here if needed
}

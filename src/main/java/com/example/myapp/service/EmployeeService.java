package com.example.myapp.service;

import com.example.myapp.entity.Employee;
import com.example.myapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    

    public Employee save(Employee employee) {
        // Perform any validation or business logic operations before saving
        return employeeRepository.save(employee);
    }
    
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }
    
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    
    public Employee update(Employee employee) {
        // Perform any validation or business logic operations before updating
        return employeeRepository.save(employee);
    }
    
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}

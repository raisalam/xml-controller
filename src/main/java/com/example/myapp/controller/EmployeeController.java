package com.example.myapp.controller;

import com.example.myapp.dto.request.EmployeeRequestDTO;
import com.example.myapp.dto.response.EmployeeResponseDTO;
import com.example.myapp.entity.Employee;
import com.example.myapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequestDTO.getFirstName());
        employee.setLastName(employeeRequestDTO.getLastName());
        employee =  employeeService.save(employee);
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setId(employee.getId());
        responseDTO.setFirstName(employee.getFirstName());
        responseDTO.setLastName(employee.getLastName());
        return responseDTO;
    }
    
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public EmployeeResponseDTO getEmployeeById(@PathVariable int id) {

        Employee employee =  employeeService.findById(id);

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setId(employee.getId());
        responseDTO.setFirstName(employee.getFirstName());
        responseDTO.setLastName(employee.getLastName());

        return responseDTO;
    }
    
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }
    
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
    }
}

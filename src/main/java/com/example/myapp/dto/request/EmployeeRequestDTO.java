package com.example.myapp.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeRequestDTO {
    private String firstName;
    private String lastName;
}

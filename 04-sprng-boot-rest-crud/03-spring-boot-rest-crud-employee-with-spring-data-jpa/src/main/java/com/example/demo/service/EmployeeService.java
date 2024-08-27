package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> findAll();
     void deleteById(int id);
     Employee findById(int id);
     Employee save(Employee employee);
}

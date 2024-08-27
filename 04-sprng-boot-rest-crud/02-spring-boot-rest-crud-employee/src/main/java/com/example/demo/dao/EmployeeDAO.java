package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    void deleteById(int id);
    Employee findById(int id);
    Employee save(Employee employee);
}

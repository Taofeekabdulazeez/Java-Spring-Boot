package com.example.demo.service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        // delegate call
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        // delegate call
        Optional<Employee> result = this.employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - "+id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // delegate call
        return this.employeeRepository.save(employee);
    }

    //@Transactional not needed
    @Override
    public void deleteById(int id) {
        // delegate call
        this.employeeRepository.deleteById(id);
    }
}

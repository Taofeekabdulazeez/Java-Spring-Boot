package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeDAOImpl;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        // delegate call
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        // delegate call
        return this.employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        // delegate call
        return this.employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        // delegate call
        this.employeeDAO.deleteById(id);
    }
}

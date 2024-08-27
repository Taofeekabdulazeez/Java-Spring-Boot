package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    // define field for entityManger
    private EntityManager entityManger;

    // setup constructor injection
    EmployeeDAOImpl(EntityManager entityManager){
        this.entityManger = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = this.entityManger.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get employee
        Employee employee = this.entityManger.find(Employee.class, id);

        // return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save employee
        Employee dbEmployee = this.entityManger.merge(employee);

        // return employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find the employee
        Employee employee = this.entityManger.find(Employee.class, id);

        // remove employee
        this.entityManger.remove(employee);
    }
}

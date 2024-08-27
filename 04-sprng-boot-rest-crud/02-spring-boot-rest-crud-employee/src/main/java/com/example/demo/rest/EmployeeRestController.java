package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // expose "/employees" endpoint and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = this.employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employeee id not found! "+employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // also just in case they pass an id in JSON, set id to 0
        // this is to force a save of new item... instead of update
        employee.setId(0);

        return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = this.employeeService.save(employee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = this.employeeService.findById(employeeId);

        if(employee == null) {
            throw new RuntimeException("Employee does not exists");
        }

        this.employeeService.deleteById(employeeId);

        return "Deleted employee ID: "+employee.getId();
    }
}

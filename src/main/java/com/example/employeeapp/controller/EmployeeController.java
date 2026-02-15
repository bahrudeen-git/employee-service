package com.example.employeeapp.controller;

import com.example.employeeapp.model.Employee;
import com.example.employeeapp.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200") 
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
    	System.out.println("*********** get employees******");
    	List<Employee> list = new ArrayList<Employee>();
    	Employee e = new Employee();
    	e.setId(1);
    	e.setName("Bahrudeen");
    	e.setDepartment("CS");
    	list.add(e);
    	
    	e = new Employee();
    	e.setId(2);
    	e.setName("Vengadesh");
    	e.setDepartment("CS");
    	list.add(e);
    	
    	e = new Employee();
    	e.setId(3);
    	e.setName("Saravanan");
    	e.setDepartment("IT");
    	list.add(e);
    	System.out.println(list);
    	return list;
       // return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        return repository.save(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return "Employee deleted";
    }
}

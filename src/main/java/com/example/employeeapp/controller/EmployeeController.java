package com.example.employeeapp.controller;

import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200") 
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

//    public EmployeeController(EmployeeRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping
    public List<Employee> getAllEmployees() {
    	System.out.println("*********** get employees******");
    	List<Employee> list = new ArrayList<Employee>();
    	/*Employee e = new Employee();
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
    	e.setName("Saravanan S");
    	e.setDepartment("IT");
    	list.add(e);
    	
    	e = new Employee();
    	e.setId(4);
    	e.setName("Saravanan J");
    	e.setDepartment("DEV");
    	list.add(e);
    	
    	e = new Employee();
    	e.setId(5);
    	e.setName("Durga");
    	e.setDepartment("DEV");
    	list.add(e);

        e = new Employee();
    	e.setId(6);
    	e.setName("Nitharshna");
    	e.setDepartment("DEV");
    	list.add(e);
    	
    	e = new Employee();
     	e.setId(7);
     	e.setName("Guna");
     	e.setDepartment("DEV");
     	list.add(e);*/
     	
     	list = employeeRepository.findAll();
    	System.out.println(list);
    	return list;
       // return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
    	employeeRepository.deleteById(id);
        return "Employee deleted";
    }
}

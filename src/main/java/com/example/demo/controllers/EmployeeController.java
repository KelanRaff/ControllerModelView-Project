package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;

@RestController
@EnableWebMvc
@ControllerAdvice
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
		@DeleteMapping(path="/api/employees/{eid}")
		public void delete(@PathVariable String eid) throws Exception {
			try {
				es.delete(eid);
			} catch (Exception e) {
				throw new Exception("Employee : " + eid + " not found");
			}
	
		}
		
		@GetMapping(path="/api/employees/get/{eid}")
		public Employee getEmployee(@PathVariable String eid) {
			return es.findEmployee(eid);
		}
	
		@GetMapping(path="/api/employees")
		public Iterable<Employee> getEmployees() {
			return es.findEmployees();
		}
		
		@PostMapping(path ="/api/employees/add", consumes="application/json")
		public void addEmployee(@RequestBody Employee e) throws Exception{
			try {
				es.add(e);
			} catch (Exception e2) {
				throw new Exception("Employee ID, Name and Salary must be provided");
			}
		}

}

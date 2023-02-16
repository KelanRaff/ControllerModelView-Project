package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service 
public class EmployeeService {
	
	@Autowired
	EmployeeRepository er;
	
	public Iterable<Employee> findEmployees() {
		try {
			return er.findAll();			
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	public Employee findEmployee(String eid) {
		try {
			return er.findByEmployeeId(eid);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	public void delete(String eid) {
		try {
			Employee employee = er.findByEmployeeId(eid);
			er.delete(employee);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	public void add(Employee employee) throws Exception {
		try {
			er.save(employee);
		}
		catch (Exception e) {
			throw new Exception("Employee : " + employee.getEid() + " already exists");
		}
	}

}

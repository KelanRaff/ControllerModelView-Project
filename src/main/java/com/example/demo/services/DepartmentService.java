package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;


@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository dr;
	
	public Iterable<Department> findDepartments() {
		try {
			return dr.findAll();			
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	public Department findDepartment(String did) {
		try {
			return dr.findByDepartmentId(did);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	public void updatedepartment(String did, Department d) {
		Department department = dr.findByDepartmentId(did);
		department.setName(d.getName());
		department.setLocation(d.getLocation());
		dr.save(department);
	}
	
	public double findTotalSalary(String did) {
		try {
			return dr.findTotalSalary(did);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
}

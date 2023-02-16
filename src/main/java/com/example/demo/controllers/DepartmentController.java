package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.example.demo.models.Department;
import com.example.demo.models.validations.departmentPUTValidations;
import com.example.demo.services.DepartmentService;

@RestController
@EnableWebMvc
@ControllerAdvice
public class DepartmentController {

	@Autowired
	DepartmentService ds;
	
	@GetMapping(path="/api/departments")
	public Iterable<Department> getDepartments() {
		return ds.findDepartments();
	}

	@Validated(departmentPUTValidations.class)
	@PutMapping(path="/api/departments/{did}")
	public void updatedepartment(@PathVariable String did,@Valid @RequestBody Department d) {
		try {
			ds.updatedepartment(did, d);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@GetMapping(path="/api/departments/totalSalary/{did}")
	public double findTotalSalary(@PathVariable String did) {
		return ds.findTotalSalary(did);
	}

}

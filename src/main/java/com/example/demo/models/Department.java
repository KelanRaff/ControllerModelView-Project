package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.example.demo.models.validations.departmentPUTValidations;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity (name="department")
public class Department {
	
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Null(message = "id must not be specified", groups = departmentPUTValidations.class)
	private String did;
	@Null(message = "did must not be specified", groups = departmentPUTValidations.class)
	private String name;
	@NotNull(message = "did must be specified", groups = departmentPUTValidations.class)
	private String location;
	@NotNull(message = "did must be specified", groups = departmentPUTValidations.class)
	@JsonBackReference
	@OneToMany(mappedBy = "dept")
	private List<Employee> employees;
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}

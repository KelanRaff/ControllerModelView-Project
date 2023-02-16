package com.example.demo.repositories;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.demo.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	@Query("from employee e where e.eid=:employeeId")
	public Employee findByEmployeeId(@Param("employeeId") String employeeId);
	
	//@Query("from employee.projects")
	//public Iterable<Employee> findByProjectId(@Param("projectId") String projectId);
}

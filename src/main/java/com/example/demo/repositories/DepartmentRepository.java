package com.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.demo.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	@Query("from department d where d.did=:departmentId")
	public Department findByDepartmentId(@Param("departmentId") String departmentId);

	@Query("select sum(e.salary) from department d left join employee e on d.id = e.dept where d.did=:departmentId")
	public double findTotalSalary(@Param("departmentId") String departmentId);
}

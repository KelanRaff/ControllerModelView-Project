package com.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
	@Query("from project p where p.pid=:projectId")
	public Project findByProjectId(@Param("projectId") String projectId);
}

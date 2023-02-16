package com.example.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Employee;
import com.example.demo.models.Project;
import com.example.demo.repositories.ProjectRepository;


@Service
public class ProjectService {

	@Autowired
	ProjectRepository pr;
		
	public void delete(String pid) {
		try {
			Project project = pr.findByProjectId(pid);
			pr.delete(project);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}

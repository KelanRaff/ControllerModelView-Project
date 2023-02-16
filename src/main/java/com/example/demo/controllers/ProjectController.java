package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.services.ProjectService;

@RestController
@EnableWebMvc
@ControllerAdvice
public class ProjectController {
	
	@Autowired
	ProjectService ps;
	
		@DeleteMapping(path="/api/projects/{pid}")
		public void delete(@PathVariable String pid) throws Exception {
			try {
				ps.delete(pid);
			} catch (Exception e) {
				throw new Exception("Employee : " + pid + " not found");
			}
		}
}

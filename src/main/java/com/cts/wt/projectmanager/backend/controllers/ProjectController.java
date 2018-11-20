package com.cts.wt.projectmanager.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.wt.projectmanager.backend.entities.Project;
import com.cts.wt.projectmanager.backend.repos.ProjectRepo;

@RestController
@CrossOrigin("*")
public class ProjectController {

	@Autowired
	ProjectRepo projectRepo;

	@PostMapping("/project")
	public ResponseEntity<Void> addProject(@RequestBody Project project) {
		projectRepo.save(project);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.CREATED);
		return rs;

	}

	@PutMapping("/project")
	public ResponseEntity<Void> updateProject(@RequestBody Project project) {
		projectRepo.save(project);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@DeleteMapping("/project/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable("id") int id) {
		projectRepo.deleteById(id);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@GetMapping("/project/{id}")
	public Project fetchProject(@PathVariable("id") int id) {
		Project project = projectRepo.findById(id);
		return project;

	}

	@GetMapping("/project")
	public List<Project> fetchAllProject() {
		List<Project> project = projectRepo.findAll();
		return project;

	}

}

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
import com.cts.wt.projectmanager.backend.repos.TaskRepo;

@RestController
@CrossOrigin("*")
public class ProjectController {

	@Autowired
	ProjectRepo projectRepo;
	


	@PostMapping("/projects")
	public ResponseEntity<Void> addProject(@RequestBody Project project) {
		projectRepo.save(project);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.CREATED);
		return rs;

	}

	@PutMapping("/projects")
	public ResponseEntity<Void> updateProject(@RequestBody Project project) {
		projectRepo.save(project);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@DeleteMapping("/projects/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable("id") int id) {
		projectRepo.deleteById(id);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@GetMapping("/projects/{id}")
	public Project fetchProject(@PathVariable("id") int id) {
		Project project = projectRepo.findById(id);
		return project;

	}

	@GetMapping("/project/{project}")
	public Project fetchProjectUsingName(@PathVariable String project) {
		Project proj = projectRepo.findByName(project);
		return proj;

	}
	@GetMapping("/projects")
	public List<Project> fetchAllProject() {
		List<Project> projects = projectRepo.findAll();
		return projects;

	}

	@GetMapping("/project")
	public List<Project> fetchCompletedProject() {
		List<Project> projects = projectRepo.findAllCompletedProject();
		return projects;

	}
}

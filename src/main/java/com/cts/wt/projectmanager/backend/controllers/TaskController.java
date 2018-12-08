package com.cts.wt.projectmanager.backend.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.wt.projectmanager.backend.entities.ParentTask;
import com.cts.wt.projectmanager.backend.entities.Project;
import com.cts.wt.projectmanager.backend.entities.Task;
import com.cts.wt.projectmanager.backend.repos.ParentTaskRepo;
import com.cts.wt.projectmanager.backend.repos.TaskRepo;

/**
 * Control for task operations.
 * 
 * @author Nilofar Sulaiman
 *
 */
@RestController
@CrossOrigin("*")
public class TaskController {

	@Autowired
	ParentTaskRepo parentTaskRepo;

	@Autowired
	TaskRepo taskRepo;

	@PostMapping("/task")
	public int addTask(@RequestBody Task task) {
		taskRepo.save(task);
		return task.getTaskId();

	}

	@PutMapping("/task")
	public ResponseEntity<Void> updateTask(@RequestBody Task task) {
		taskRepo.save(task);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@DeleteMapping("/task/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") int id) {
		taskRepo.deleteById(id);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@GetMapping("/task/{id}")
	public Task fetchTask(@PathVariable("id") int id) {
		Task task = taskRepo.findById(id);
		return task;

	}

	@GetMapping("/tasks")
	public List<Task> fetchCompletedProject() {
		List<Task> task = taskRepo.findAllCompletedProject();
		return task;

	}

	@GetMapping("/tasks/{projectId}")
	public List<Task> fetchTaskByProject(@PathVariable("projectId") int projectId) {
		List<Task> task = taskRepo.findTaskByProject(projectId);
		return task;

	}

	@GetMapping("/task")
	public List<Task> fetchAllTask() {
		List<Task> task = taskRepo.findAll();
		return task;

	}

}

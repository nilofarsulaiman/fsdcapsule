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

import com.cts.wt.projectmanager.backend.entities.ParentTask;
import com.cts.wt.projectmanager.backend.repos.ParentTaskRepo;

@RestController
@CrossOrigin("*")
public class ParentTaskController {

	@Autowired
	ParentTaskRepo parentTaskRepo;

	@PostMapping("/parentTask")
	public int addParentTask(@RequestBody ParentTask parentTask) {
		parentTaskRepo.save(parentTask);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.CREATED);
		return parentTask.getId();

	}

	@PutMapping("/parentTask")
	public ResponseEntity<Void> updateParentTask(@RequestBody ParentTask parentTask) {
		parentTaskRepo.save(parentTask);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@DeleteMapping("/parentTask/{id}")
	public ResponseEntity<Void> deleteParentTask(@PathVariable("id") int id) {
		parentTaskRepo.deleteById(id);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@GetMapping("/parentTask/{id}")
	public ParentTask fetchParentTask(@PathVariable("id") int id) {
		ParentTask parentTask = parentTaskRepo.findById(id);
		return parentTask;

	}

	@GetMapping("/parentTask")
	public List<ParentTask> fetchAllParentTask() {
		List<ParentTask> parentTask = parentTaskRepo.findAll();
		return parentTask;

	}

}

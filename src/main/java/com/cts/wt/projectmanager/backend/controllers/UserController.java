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
import com.cts.wt.projectmanager.backend.entities.User;
import com.cts.wt.projectmanager.backend.repos.UserRepo;
import com.cts.wt.projectmanager.backend.repos.UserRepo;

/**
 * Control for User operations.
 * 
 * @author Nilofar Sulaiman
 *
 */
@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserRepo userRepo;
	UserRepo UserRepo;

	@PostMapping("/user")
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		userRepo.save(user);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.CREATED);
		return rs;

	}

	@PutMapping("/user")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		userRepo.save(user);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	
	@PutMapping("/user/project")
	public ResponseEntity<Void> updateUserProject(@RequestBody User user) {
		userRepo.save(user);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		userRepo.deleteById(id);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;

	}

	@GetMapping("/user/{id}")
	public User fetchUser(@PathVariable("id") int id) {
		User user = userRepo.findById(id);
		return user;

	}
	
	@GetMapping("/userName/{name}")
	public User filterManager(@PathVariable String name) {
		User user = userRepo.findIdByName(name);
		return user;

	}

	@GetMapping("/user")
	public List<User> fetchAllUser() {
		List<User> user = userRepo.findAll();
		return user;

	}

}

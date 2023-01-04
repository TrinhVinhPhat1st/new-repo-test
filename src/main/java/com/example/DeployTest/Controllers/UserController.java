package com.example.DeployTest.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DeployTest.Models.User;
import com.example.DeployTest.Repo.UserRepo;

import antlr.collections.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRepo repo; 
	
	@GetMapping
	public ArrayList<User> getAll() {
		return (ArrayList<User>) repo.findAll();
	}
	
	@GetMapping("/{id}")
	public User getOne(@PathVariable Long id) {
		return repo.findById(id).get();
	}
	
	@PostMapping
	public User addOne(@RequestBody User user) {
		return repo.save(user);
	}
}

package com.example.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpademo.data.User;
import com.example.jpademo.repository.UserRepository;

@RestController
@RequestMapping("/test")
public class MyController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getAll() {
		Iterable<User> iterable = userRepository.findAll();
//		List<User> userList = new ArrayList<>();
//		iterable.forEach(userList::add);
		return ResponseEntity.ok(iterable);
		

	}
	
	@PostMapping
	public ResponseEntity<User> newUser(@RequestParam String name, @RequestParam String email) {
		
		User newUser = new User();
		newUser.setName(name);
		newUser.setEmail(email);
		
		// reassign newUser as the repository will assign the id value to our new user and return the user object
		newUser = userRepository.save(newUser);
		
		return ResponseEntity.ok(newUser);
		
	}

}

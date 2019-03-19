package edu.eci.arsw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.arsw.model.User;
import edu.eci.arsw.service.SuperEasyServices;

@RestController
@RequestMapping(value = "/superEasy")

public class SuperEasyAPIController {
	
	@Autowired
	private SuperEasyServices superEasyServices;
	
	@PostMapping("{name}")
	public ResponseEntity<?> postUser(@PathVariable String name, @RequestBody User user) {

		superEasyServices.createUser(user);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}

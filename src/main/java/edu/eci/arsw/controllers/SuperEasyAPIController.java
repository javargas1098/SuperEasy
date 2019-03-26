package edu.eci.arsw.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.arsw.model.User;
import edu.eci.arsw.services.contracts.IUserServices;

@RestController
@RequestMapping(value = "/superEasy")

public class SuperEasyAPIController {
	
	@Autowired
	private IUserServices userServices;

	@PostMapping("/saveUser")
	public ResponseEntity<?> postUser(@RequestBody User user) {

		userServices.create(user);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value= "/user" , method= RequestMethod.GET)
	public ResponseEntity<?> GetAllUsers(){
		try {

			return new ResponseEntity<>(userServices.list(),HttpStatus.OK);
		}
		catch(Exception e){
			Logger.getLogger(SuperEasyAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error no Users Found",HttpStatus.NOT_FOUND);
			
		}
		
	}
}

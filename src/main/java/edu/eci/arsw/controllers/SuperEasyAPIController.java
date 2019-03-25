package edu.eci.arsw.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.arsw.model.User;
<<<<<<< HEAD
=======
import edu.eci.arsw.services.SuperEasyServices;
>>>>>>> a
import edu.eci.arsw.services.contracts.IUserServices;

@RestController
@RequestMapping(value = "/superEasy")

public class SuperEasyAPIController {
	
	@Autowired
<<<<<<< HEAD
	private IUserServices userServicies;

	
=======
	private IUserServices userServices;

	@PostMapping("user")
	public ResponseEntity<?> postUser(@RequestBody User user) {

		userServices.create(user);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
>>>>>>> a
	
	@RequestMapping(value= "/user" , method= RequestMethod.GET)
	public ResponseEntity<?> GetAllUsers(){
		try {
<<<<<<< HEAD
			return new ResponseEntity<>(userServicies.list(),HttpStatus.OK);
=======
			return new ResponseEntity<>(userServices.list(),HttpStatus.OK);
>>>>>>> a
		}
		catch(Exception e){
			Logger.getLogger(SuperEasyAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error no Users Found",HttpStatus.NOT_FOUND);
			
		}
		
	}
	@PostMapping("{user}")
	public ResponseEntity<?> postUser(@RequestBody User user) {

		userServicies.create(user);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}

package edu.eci.arsw.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.arsw.model.User;
import edu.eci.arsw.services.contracts.IAuctionServices;
import edu.eci.arsw.services.contracts.IUserServices;

@RestController
@RequestMapping(value = "/superEasy")

public class SuperEasyAPIController {
	
	@Autowired
	private IUserServices userServices;
	@Autowired
	private IAuctionServices auctionServices;

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST )
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
			userServices.create(user);
			//System.out.println(user.getNumber());
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e){
			Logger.getLogger(SuperEasyAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
			
		}

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
	
	@RequestMapping(value= "/credentials/{email}/{password}" , method= RequestMethod.GET)
	public ResponseEntity<?> EvaluateCredentials(@PathVariable String email,@PathVariable String password){
		try {
			User u = userServices.get(email);
			if(u.getPassword().equals(password)) {
				return new ResponseEntity<>(true,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(false,HttpStatus.OK);
			}
			
		}
		catch(Exception e){
			Logger.getLogger(SuperEasyAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@RequestMapping(value= "/user/{email}" , method= RequestMethod.GET)
	public ResponseEntity<?> GetUser(@PathVariable String email){
		try {

			return new ResponseEntity<>(userServices.get(email),HttpStatus.OK);
		}
		catch(Exception e){
			Logger.getLogger(SuperEasyAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error no User Found",HttpStatus.NOT_FOUND);
			
		}
	}
	
	@GetMapping("/auctions")
	public ResponseEntity<?> getAllAuctions() {
		try {
			return new ResponseEntity<>(auctionServices.list(),HttpStatus.OK);
		}
		catch(Exception e){
			Logger.getLogger(SuperEasyAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error no Users Found",HttpStatus.NOT_FOUND);
			
		}
	}
}

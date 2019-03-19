package edu.eci.arsw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.SuperEasyPersistence;

@Service
public class SuperEasyServices {
	
	@Autowired
	SuperEasyPersistence superEasyPersistence;

	public void createUser(User user) {
		
		superEasyPersistence.createUser(user);
		
	}
	
	
	
}

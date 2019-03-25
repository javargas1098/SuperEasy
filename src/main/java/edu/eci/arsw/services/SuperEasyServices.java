package edu.eci.arsw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistences.SuperEasyPersistence;
import edu.eci.arsw.persistences.ipml.UserRepositoryPersistence;

@Component
public class SuperEasyServices {
	
	@Autowired
	SuperEasyPersistence superEasyPersistence;
	@Autowired
	UserRepositoryPersistence urp;

	public void createUser(User user) {
		
		urp.save(user);
		
	}

	public List<User> getUsers() {
		return urp.findAll();
	}
	
	

	
	
	
	
}

package edu.eci.arsw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistences.ipml.InMerySuperEasyPersistence;
import edu.eci.arsw.persistences.ipml.UserRepositoryPersistence;

@Component
public class SuperEasyServices {
	
	@Autowired
	InMerySuperEasyPersistence superEasyPersistence;
	@Autowired
	UserRepositoryPersistence urp;

	public void createUser(User user) {
		
		urp.save(user);
		
	}

	public List<User> getUsers() {
		return urp.findAll();
	}
	
	

	
	
	
	
}

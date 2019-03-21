package edu.eci.arsw.persistence;

import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;

@Service
public interface SuperEasyPersistence {
	
	public void createUser (User user);
	
}

package edu.eci.arsw.persistences;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;

@Service
public interface SuperEasyPersistence {
	
	public void createUser (User user);

	
	
}

package edu.eci.arsw.persistences.repositories;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;

@Repository
public interface IUserRepository extends DAO<User, Long>  {
	public User GetUserByName(String username);
	public void createUser(User usuario);
	
}

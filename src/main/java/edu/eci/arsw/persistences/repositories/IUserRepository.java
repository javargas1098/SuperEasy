package edu.eci.arsw.persistences.repositories;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.model.User;

@Repository
public interface IUserRepository extends DAO<User, Long>  {
	public void createUser(User usuario);
	User getUserByEmail(String email);
	User getUserById(long idUser);
}

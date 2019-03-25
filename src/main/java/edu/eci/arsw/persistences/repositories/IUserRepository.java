package edu.eci.arsw.persistences.repositories;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.model.User;

@Repository
public interface IUserRepository extends DAO<User, Long>  {
	User GetUserByEmail(String email);
}

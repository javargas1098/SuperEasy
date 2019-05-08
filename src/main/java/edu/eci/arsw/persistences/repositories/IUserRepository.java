package edu.eci.arsw.persistences.repositories;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.model.User;

@Repository
public interface IUserRepository extends DAO<User, Long>  {
	User getUserByEmail(String email) throws SQLException;

	User getUserById(long idUser) throws SQLException;

}

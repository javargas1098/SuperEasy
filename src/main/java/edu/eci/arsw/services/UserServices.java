package edu.eci.arsw.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.persistences.repositories.IUserRepository;
import edu.eci.arsw.services.contracts.IUserServices;
import edu.eci.arsw.model.User;

@Component
public class UserServices implements IUserServices {

	@Autowired
	@Qualifier("UserPostgresRepository")
	private IUserRepository userRepository;

	@Override
	public List<User> list() throws SQLException, ParseException {
		return userRepository.findAll();
	}

	@Override
	public User create(User user) throws SQLException {
		if (null == user.getEmail())
			throw new RuntimeException("Id invalid");
		else if (userRepository.getUserByEmail(user.getEmail()) != null)
			throw new RuntimeException("The user already exists");
		else
			userRepository.save(user);
		return user;
	}

	@Override
	public User get(String email) throws SQLException {
		
		return userRepository.getUserByEmail(email);
	}

	@Override
	public void deleteUser(User user) {

		userRepository.delete(user);
	}

	@Override
	public void removeUser(String email) {
		userRepository.remove(email);
	}

	@Override
	public void updateUser(User user) {
		userRepository.update(user);
	}

	@Override
	public void updateJairitos(String email, int value) throws SQLException {
		
		userRepository.updateJairitos(email, value);
		
	}

	@Override
	public void updateCongelados(String email, int value) throws SQLException {
		
		userRepository.updateCongelados(email, value);
		
	}

}

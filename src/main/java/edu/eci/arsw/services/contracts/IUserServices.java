package edu.eci.arsw.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;


@Service
public interface IUserServices {
	
	List<User> list();
    User create(User user);
    User get(String email);
    void deleteUser(User user);
    void removeUser(String email);
	void updateUser(User user);
	User getUserByName(String name);
	
}

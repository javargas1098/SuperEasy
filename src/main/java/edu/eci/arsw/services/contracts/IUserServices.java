package edu.eci.arsw.services.contracts;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arsw.model.User;


@Service
public interface IUserServices {
	
	List<User> list() throws SQLException, ParseException;
    User create(User user) throws SQLException;
    User get(String email) throws SQLException;
    void deleteUser(User user);
    void removeUser(String email);
	void updateUser(User user);
	void updateJairitos(String email,int value) throws SQLException;
	void updateCongelados(String email,int value) throws SQLException;
	
}

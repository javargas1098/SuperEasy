package edu.eci.arsw.persistences.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistences.SuperEasyPersistence;
import edu.eci.arsw.persistences.repositories.IUserRepository;


@Component("superEasyPersistence")
public class InMerySuperEasyPersistence implements SuperEasyPersistence {

//	@Autowired
//	BiddingRepository br;
//
//	@Autowired
//	SubastasReposiroty sr;

	@Autowired
	private IUserRepository ur;

	@Override
	public void createUser(User user) {
		ur.createUser(user);
		
	}
	public List<User> getUsers(){
		return ur.findAll();
	}

	

}

package edu.eci.arsw.persistence.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.SuperEasyPersistence;
import edu.eci.arsw.persistence.repository.BiddingRepository;
import edu.eci.arsw.persistence.repository.SubastasReposiroty;
import edu.eci.arsw.persistence.repository.UserRepository;

@Component("superEasyPersistence")
public class InMerySuperEasyPersistence implements SuperEasyPersistence {

//	@Autowired
//	BiddingRepository br;
//
//	@Autowired
//	SubastasReposiroty sr;

	@Autowired
	private UserRepository ur;

	@Override
	public void createUser(User user) {
		ur.createUser(user);
		
	}
	public List<User> getUsers(){
		return ur.findAll();
	}

	

}

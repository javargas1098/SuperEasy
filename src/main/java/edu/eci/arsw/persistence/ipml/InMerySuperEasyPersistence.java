package edu.eci.arsw.persistence.ipml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.SuperEasyPersistence;
import edu.eci.arsw.repository.BiddingRepository;
import edu.eci.arsw.repository.SubastasReposiroty;
import edu.eci.arsw.repository.UserRepository;

@Component("superEasyPersistence")
public class InMerySuperEasyPersistence implements SuperEasyPersistence {

	@Autowired
	BiddingRepository br;

	@Autowired
	SubastasReposiroty sr;

	@Autowired
	UserRepository ur;

	@Override
	public void createUser(User user) {
		ur.save(user);
		
	}

}

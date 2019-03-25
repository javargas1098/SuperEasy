//package edu.eci.arsw.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import edu.eci.arsw.model.User;
//<<<<<<< HEAD
//
//import edu.eci.arsw.persistences.ipml.InMerySuperEasyPersistence;
//
//import edu.eci.arsw.persistences.ipml.UserRepositoryPersistence;
//=======
//import edu.eci.arsw.persistences.SuperEasyPersistence;
//import edu.eci.arsw.persistences.repositories.IUserRepository;
//
//@Component
//public class SuperEasyServices {
//
//	@Autowired
//	InMerySuperEasyPersistence superEasyPersistence;
//	@Autowired
//	IUserRepository ur;
//
//	public void createUser(User user) {
//<<<<<<< HEAD
//
//		urp.save(user);
//
//=======
//		
//		ur.save(user);
//		
//>>>>>>> cambios
//	}
//
//	public List<User> getUsers() {
//		return ur.findAll();
//	}
//
//}

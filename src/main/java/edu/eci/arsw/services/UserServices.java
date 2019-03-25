package edu.eci.arsw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.arsw.persistences.repositories.IUserRepository;
import edu.eci.arsw.services.contracts.IUserServices;

@Component
public class UserServices implements IUserServices{
	
	@Autowired
    @Qualifier("UserPostgresRepository")
    private IUserRepository userRepository;
	
}

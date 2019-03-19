package edu.eci.arsw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.eci.arsw.model.User;

public interface UserRepository extends CrudRepository<User, Long>  {
	
		
	
}

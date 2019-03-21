package edu.eci.arsw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
	
		
	
}

package com.propfix.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "/")
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, String>{
	
	@RestResource(rel = "search-by-usertype", path = "usertype")
	List<User> getByUserType(@Param("userType") String userType);
	
	User findByUsername(String username);
}

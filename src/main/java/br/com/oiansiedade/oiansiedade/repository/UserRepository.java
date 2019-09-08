package br.com.oiansiedade.oiansiedade.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.oiansiedade.oiansiedade.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);

}
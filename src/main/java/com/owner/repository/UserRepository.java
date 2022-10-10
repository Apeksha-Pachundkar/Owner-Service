package com.owner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.owner.model.User;

public interface UserRepository extends MongoRepository<User,Long>{

	public User save(User user);

	//@Query("select u from User u where u.username=?1")
	 @Query("{username:'?0'}")
	User findByUsername(String username);

	public void deleteById(Long userId);

	

}

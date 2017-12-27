package me.aboullaite.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.aboullaite.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	public abstract User findUserByUserId(String userId);
}

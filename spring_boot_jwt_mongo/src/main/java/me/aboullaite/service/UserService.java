package me.aboullaite.service;

import me.aboullaite.model.User;

public interface UserService {

	User save(User user);

	User findByUserId(String userId);
}

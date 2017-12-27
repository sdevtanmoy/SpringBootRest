package me.aboullaite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import me.aboullaite.dao.UserRepository;
import me.aboullaite.jwt.JwtUserFactory;
import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findByUserId(String userId) {
		return this.userRepository.findUserByUserId(userId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = this.userRepository.findUserByUserId(username);

	        if (user == null) {
	            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	        } else {
	            return JwtUserFactory.create(user);
	        }
	}

}

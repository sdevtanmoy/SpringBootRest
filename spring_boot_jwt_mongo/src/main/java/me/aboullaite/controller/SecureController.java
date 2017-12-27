package me.aboullaite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

@RestController
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}

	@PostMapping(value = "/user/userId")
	public User findByUserId(@RequestBody String userId) {
		return userService.findByUserId(userId);
	}

	@PostMapping(value = "/user/update")
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}
}

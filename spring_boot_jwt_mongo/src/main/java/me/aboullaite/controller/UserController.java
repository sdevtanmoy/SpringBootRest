package me.aboullaite.controller;

//import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.aboullaite.jwt.JwtTokenUtil;
import me.aboullaite.jwt.JwtUser;
import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

//@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		if(null == user || user.getUserId().isEmpty()){
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
		User result = userService.save(user);
		
		if(null == result){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		else{
			return new ResponseEntity<User>(result, HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody User login, Device device) {

		//String jwtToken = "";
		
		if(null == login || null == login.getUserId() || null == login.getPasswd()) {
			//throw new ServletException("Please fill in username and password");
			return new ResponseEntity<String>("Please fill in username and password", HttpStatus.NOT_FOUND);
		}
		
		// Perform the security
        /*final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		login.getUserId(),
                		login.getPasswd()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
		*/
		/*if(null == user) {
			//throw new ServletException("User Id not found");
			return new ResponseEntity<String>("User Id not found", HttpStatus.NOT_FOUND);
		}
		
		if(!passwd.equals(user.getPasswd())) {
			//throw new ServletException("Invalid login. Please check your name and password.");
			return new ResponseEntity<String>("Invalid login. Please check your name and password.", HttpStatus.FORBIDDEN);
		}*/
		// Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUserId());
        if(null == userDetails) {
        		return new ResponseEntity<String>("Invalid login. Please check your name and password.", HttpStatus.FORBIDDEN);
        }
        		
        final String token = jwtTokenUtil.generateToken(userDetails, device);
        
		return new ResponseEntity<String>(token, HttpStatus.OK);
	}
}

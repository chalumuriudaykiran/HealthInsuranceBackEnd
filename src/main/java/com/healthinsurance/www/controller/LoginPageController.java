package com.healthinsurance.www.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthinsurance.www.entity.LoginPage;
import com.healthinsurance.www.repo.RegisterRepository;
import com.healthinsurance.www.service.LoginService;
import com.healthinsurance.www.service.RegisterService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Loginpage")
public class LoginPageController

{
	@Autowired
	LoginService loginService;
	@Autowired
	RegisterRepository registerRepository;
	@Autowired
	RegisterService registerationService;
	
//	@PostMapping("/check")
//	public String  addlogin(@RequestBody LoginPage loginPage) {
//		Optional<LoginPage> optionalUser=loginService.findByEmail(loginPage.getUname());
//		
//		 if (optionalUser.isPresent()) {
//			 LoginPage user = optionalUser.get();
//		        // Check if passwords match (you should hash the passwords for security)
//		        if (user.getPassword().equals(loginPage.getPassword())) {
//		            // Passwords match, login successful
//		            return "Login successfully";
//		        } else {
//		          
//		            return "Invalid credentials";
//		        }
//		        
//		 } 
//		 else {
//		        // User with the given email not found
//		        return "User not found";
//		    }
//		 
//		 
//	}
	@PostMapping("/check")
    public ResponseEntity<String> addLogin(@RequestBody LoginPage loginPage) {
        Optional<LoginPage> optionalUser = loginService.findByEmail(loginPage.getUname());

        if (optionalUser.isPresent()) {
            LoginPage user = optionalUser.get();
            if (loginService.checkPassword(user, loginPage.getPassword())) {
                return ResponseEntity.ok("Login successfully");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
	@GetMapping("/getAll")
	public List<LoginPage> getAll(@RequestBody LoginPage loginPage)
	{
		return loginService.getAll(loginPage);
	}
	
	@PutMapping
	public LoginPage update(@RequestBody LoginPage loginPage)
	{
		return loginService.update(loginPage);
	}
	

}

package com.healthinsurance.www.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.healthinsurance.www.entity.LoginPage;
import com.healthinsurance.www.repo.LoginRepository;



@Service
public class LoginService
{
	@Autowired
	LoginRepository loginRepository;
	
	public List<LoginPage> getAll(LoginPage loginPage) {
		return loginRepository.findAll();
	}


    public Optional<LoginPage> findByEmail(String uname) {
        return Optional.of(loginRepository.findByUname(uname));
    }

    public boolean checkPassword(LoginPage user, String rawPassword) {
        // Implement password hashing comparison here
        // Example using plain text for simplicity; replace with proper hashing
        return user.getPassword().equals(rawPassword);
    }
	

	public LoginPage update(LoginPage loginPage) {
		LoginPage login=loginRepository.findById(loginPage.getUname()).get();
		login.setPassword(loginPage.getPassword());
		
		return loginRepository.save(login);

	}
	

	}





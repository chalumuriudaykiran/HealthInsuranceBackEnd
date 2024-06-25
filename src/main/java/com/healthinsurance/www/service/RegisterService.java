//package com.healthinsurance.www.service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.healthinsurance.www.entity.LoginPage;
//import com.healthinsurance.www.entity.RegisterationPage;
//import com.healthinsurance.www.repo.LoginRepository;
//import com.healthinsurance.www.repo.RegisterRepository;
//
//import jakarta.servlet.Registration;
//
//@Service
//public class RegisterService {
//	@Autowired
//	RegisterRepository registerRepository;
//	@Autowired
//	LoginRepository loginRepository;
//
//	private String customerId = generateOTP(5);
//
//	public RegisterationPage createUser(RegisterationPage register) {
//		register.setCustomerId(customerId);
//
//		RegisterationPage reg = registerRepository.save(register);
//		reg.getCustomerId();
//		LoginPage user1 = new LoginPage();
//		user1.setUname(reg.getEmail());
//		user1.setCustomerId(reg.getCustomerId());
//		user1.setPassword(reg.getPassword());
//		loginRepository.save(user1);
//
//		return registerRepository.save(register);
//
//	}
//
//	public List<RegisterationPage> getAll() {
//		return registerRepository.findAll();
//	}
//
//	public boolean check(String uname, String password) {
//		RegisterationPage reg = registerRepository.findByEmail(uname);
//		if (reg == null) {
//			return false;
//		}
//
//		return reg.getPassword().equals(password);
//	}
//
//	public String generateOTP(int length) {
//		// TODO Auto-generated method stub
//		String numbers = "0123456789";
//
//		StringBuilder otp = new StringBuilder(length);
//
//		Random random = new Random();
//		for (int i = 0; i <= length; i++) {
//			otp.append(numbers.charAt(random.nextInt(numbers.length())));
//		}
//
//		return otp.toString();
//	}
//
//	public boolean checkMail(String email) {
//		
//   Optional<RegisterationPage> register = Optional.ofNullable(registerRepository.findByEmail(email));
//	    
//	    // Check if the Optional is empty
//	    if (register.isEmpty()) {
//	        return false ;
//	    }
//	    return true;
//	
//
//	}
//////		public RegisterationPage updateRegisterDetails(String email,RegisterationPage registerationPage) {
////			public RegisterationPage update(String email, RegisterationPage registerationPage) {
////				
////				RegisterationPage reg=registerRepository.findByEmail(email);
//////				reg.setAddress(registerationPage.getAddress());
////				reg.setPhn(registerationPage.getPhn());
////				reg.setEmail(registerationPage.getEmail());
////				LoginPage login=loginRepository.findByUname(email);
////				 
////				login.setUname(registerationPage.getEmail());
////				loginRepository.save(login);
////				
////				
////				
////				return registerRepository.save(reg);
//////				return registerRepo.save(register);
////			}
//
//	public RegisterationPage getByEmail(String email) {
//		// TODO Auto-generated method stub
//		return registerRepository.findByEmail(email);
//	}
//
//	public RegisterationPage findByEmail(String email) {
//		// TODO Auto-generated method stub
//		return registerRepository.findByEmail(email);
//	}
//
//}
//

package com.healthinsurance.www.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthinsurance.www.entity.LoginPage;
import com.healthinsurance.www.entity.RegisterationPage;
import com.healthinsurance.www.repo.LoginRepository;
import com.healthinsurance.www.repo.RegisterRepository;

@Service
public class RegisterService {

	@Autowired
	RegisterRepository registerRepository;

	@Autowired
	LoginRepository loginRepository;

	private String customerId = generateOTP(5);

	public RegisterationPage createUser(RegisterationPage register) {
		register.setCustomerId(customerId);

		RegisterationPage reg = registerRepository.save(register);
		reg.getCustomerId();
		LoginPage user1 = new LoginPage();
		user1.setUname(reg.getEmail());
		user1.setCustomerId(reg.getCustomerId());
		user1.setPassword(reg.getPassword());
		loginRepository.save(user1);

		return registerRepository.save(register);
	}

	public List<RegisterationPage> getAll() {
		return registerRepository.findAll();
	}

	public boolean check(String uname, String password) {
		RegisterationPage reg = registerRepository.findByEmail(uname);
		if (reg == null) {
			return false;
		}
		return reg.getPassword().equals(password);
	}

	public String generateOTP(int length) {
		String numbers = "0123456789";

		StringBuilder otp = new StringBuilder(length);

		Random random = new Random();
		for (int i = 0; i < length; i++) { // Adjusted loop condition to < length
			otp.append(numbers.charAt(random.nextInt(numbers.length())));
		}

		return otp.toString();
	}

	public boolean checkMail(String email) {
		Optional<RegisterationPage> register = Optional.ofNullable(registerRepository.findByEmail(email));
		return register.isPresent();
	}

	public RegisterationPage getByEmail(String email) {
		return registerRepository.findByEmail(email);
	}

	public RegisterationPage findByEmail(String email) {
		return registerRepository.findByEmail(email);
	}

public RegisterationPage update(RegisterationPage register, String email) {
		
	RegisterationPage reg=registerRepository.findByEmail(email);
		reg.setUname(register.getUname());
		reg.setAddress(register.getAddress());
		reg.setPhn(register.getPhn());
		reg.setEmail(register.getEmail());
	 LoginPage login=loginRepository.findByUname(email);
		 
		login.setUname(register.getEmail());
		loginRepository.save(login);
		
		
		
		return registerRepository.save(reg);
//		return registerRepo.save(register);
	}
	
}
//
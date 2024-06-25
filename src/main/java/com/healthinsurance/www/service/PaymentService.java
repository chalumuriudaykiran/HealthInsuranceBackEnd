package com.healthinsurance.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthinsurance.www.entity.PaymentPage;
import com.healthinsurance.www.entity.RegisterationPage;
import com.healthinsurance.www.repo.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepo;
	
	

	public PaymentPage addCustomer(PaymentPage payment,RegisterationPage register) {
		// TODO Auto-generated method stub
		 payment.setRegister(register);
	return paymentRepo.save(payment);
	}

	public List<PaymentPage> getCustomer(String customerId) {
        return paymentRepo.findByRegisterationPageCustomerId(customerId);
    }

	public List<PaymentPage> getCustomerByMail(String email) {
		
		return paymentRepo.findAllByRegisterEmail(email);
	}

	
		

}

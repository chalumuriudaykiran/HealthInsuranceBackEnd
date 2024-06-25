package com.healthinsurance.www.controller;

import java.io.IOException;
//import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthinsurance.www.entity.PaymentPage;
import com.healthinsurance.www.entity.RegisterationPage;
import com.healthinsurance.www.service.InvoiceService;
import com.healthinsurance.www.service.PaymentService;
import com.healthinsurance.www.service.RegisterService;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	RegisterService registerService;
	@Autowired
	InvoiceService invoiceService;

	@PostMapping("/addCustomer/{email}")
	public ResponseEntity<?> addCustomer(@RequestBody PaymentPage payment, @PathVariable String email) {
		// Check if the user with the provided email exists in the registration table
		RegisterationPage register = registerService.findByEmail(email);
		if (register == null) {
			return ResponseEntity.badRequest().body("User with email " + email + " not found");
		}

		// Proceed with creating the payment record
		PaymentPage createdPayment = paymentService.addCustomer(payment, register);
		return ResponseEntity.ok(createdPayment);
	}

	@GetMapping("/getCustomerDetails/{email}")
	public List<PaymentPage> getCustomerDetails(@PathVariable String email) {
		return paymentService.getCustomer(email);
	}

	@GetMapping("/getAllCustomerDetailsByMail/{email}")
	public List<PaymentPage> getAllDetailsByMail(@PathVariable String email) {
		return paymentService.getCustomerByMail(email);
	}

	@GetMapping("/create")
	public void createPdf(@RequestParam("userId") String userId, HttpServletResponse response) {
		// Setting content type and response headers
		response.setContentType("application/pdf");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf");

		// Initialize the invoice service with the provided userId
		invoiceService.init(userId);

		try {
			invoiceService.export(response);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}

}

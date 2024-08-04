package com.cg.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Cibil;
import com.cg.entity.PaymentHistory;
import com.cg.repository.LoanRepository;

@RestController
@RequestMapping("/validate")
public class LoanValidationController {
 
	@Autowired
	private LoanRepository loanRepository;
	
	   @GetMapping("/cibil/{pan}")
	    public Cibil getCibil(@PathVariable String pan) {
	        // Logic to validate the loan
		   Cibil ccc=new Cibil();
	        //  return new ResponseEntity<>(ccc, HttpStatus.ACCEPTED);
		   return ccc;
	    }
	   
	   @GetMapping("/payment/{pan}")
	    public List<PaymentHistory> getPaymentHistory(@PathVariable String pan) {
	        // Logic to validate the loan
		   List<PaymentHistory> pp= loanRepository.findAllById(Arrays.asList(pan));
	        return pp;
	    }
	   
	   @GetMapping("/loanDetails")
	    public List<PaymentHistory> loanDetails(@PathVariable String pan) {
	        // Logic to validate the loan
		   List<PaymentHistory> pp= loanRepository.findAllById(Arrays.asList(pan));
	        return pp;
	    }
}

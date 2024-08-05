package com.cg.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.EducationLoanDao;
import com.cg.dao.HomeLoanDao;
import com.cg.dao.PersonalLoanDao;
import com.cg.entity.EducationLoan;
import com.cg.serviceImpl.EducationServiceImpl;
import com.cg.serviceImpl.HomeServiceImpl;
import com.cg.serviceImpl.PersonalServiceImpl;

@RestController
@RequestMapping("/loan")
public class CustomerController {

	@Autowired
	private EducationServiceImpl educationloanservice;
	
	@Autowired
	private HomeServiceImpl homeloanservice;
	
	@Autowired
	private PersonalServiceImpl personalloanservice;
	
	 @PostMapping("/education")
	    public  ResponseEntity<Object> applyEducationLoan(@RequestBody EducationLoanDao eduLoanRequest) {
		 Map<String,String> hs=new HashMap<>();
		 try {
		 EducationLoanDao edu=  educationloanservice.applyEducationLoan(eduLoanRequest);
		 if(edu != null) {
               // hs.put("customer education loan saved successfully",ResponseEntity.accepted().toString());
                //return new ResponseEntity<object>("customer education loan saved successfully",ResponseEntity.accepted().toString());
			 return new ResponseEntity<>("customer education loan saved successfully", HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>("customer education loan failed to save", HttpStatus.NOT_ACCEPTABLE);
		 }
			 
		 }
		 catch(Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		 }
		 
	    }
	 
	 
    @PostMapping("/home")
    public  ResponseEntity<Object> applyHomeLoan(@RequestBody HomeLoanDao homeLoanRequest) {
		 Map<String,String> hs=new HashMap<>();
		 try {
		 HomeLoanDao home=  homeloanservice.applyHomeLoan(homeLoanRequest);
		 if(home != null) {
              // hs.put("customer education loan saved successfully",ResponseEntity.accepted().toString());
               //return new ResponseEntity<object>("customer education loan saved successfully",ResponseEntity.accepted().toString());
			 return new ResponseEntity<>("customer home loan saved successfully", HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>("customer home loan failed to save", HttpStatus.NOT_ACCEPTABLE);
		 }
			 
		 }
		 catch(Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		 }
		 
	    }

    @PostMapping("/personal")
    public  ResponseEntity<Object> applyPersonalLoan(@RequestBody PersonalLoanDao personalLoanRequest) {
		 Map<String,String> hs=new HashMap<>();
		 try {
		 PersonalLoanDao home=  personalloanservice.applyPersonalLoan(personalLoanRequest);
		 if(home != null) {
             // hs.put("customer education loan saved successfully",ResponseEntity.accepted().toString());
              //return new ResponseEntity<object>("customer education loan saved successfully",ResponseEntity.accepted().toString());
			 return new ResponseEntity<>("customer personal loan saved successfully", HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>("customer personal loan failed to save", HttpStatus.NOT_ACCEPTABLE);
		 }
			 
		 }
		 catch(Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		 }
		 
	    }
}

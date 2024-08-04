package com.cg.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.config.RestTemplateUtility;
import com.cg.dao.Cibil;
import com.cg.dao.PaymentHistory;
import com.cg.entity.Customer;
import com.cg.repo.CustomerRepository;

@RestController("/admin")
public class AdminController {
	  @Autowired
	    private RestTemplate restTemplate;
	  
	  @Autowired
	  private CustomerRepository customerRepository;
	
	@PostMapping("/admin/approveAndReject")
	public ResponseEntity<Object> approveLoan(@RequestBody Map<String,String> request){
		// get cibil by restTemplate
		String panId=request.get("pan");
		String url="https://localhost:9000/validate/cibil/"+panId;
		Cibil cc= restTemplate.getForObject(url, Cibil.class);
		//get payment history by restemplate
		String paymentUrl="https://localhost:9000/validate/payment/"+panId;
		PaymentHistory  pp= restTemplate.getForObject(url, PaymentHistory.class);
		//agar cibil ya payment history ka flag false hai to customer table ke flag me false dal do. elss=e true;
	//	Optional<Customer> cust=customerRepository.findById(panId);
		boolean approveReject=(pp.isPending() && !cc.isLow())?true:false;
           if(approveReject) {
			customerRepository.saveByPanId(panId,approveReject);
			return new ResponseEntity<>("loan approved",HttpStatus.ACCEPTED);
           }
           else {
        	   customerRepository.saveByPanId(panId,approveReject);
   			return new ResponseEntity<>("loan rejected",HttpStatus.NOT_ACCEPTABLE);
           }
           
		
	}
	
	@PostMapping("/admin/passwordReset")
	public ResponseEntity<Object> passwordReset(@RequestBody Map<String,String> passDetails){
		 // get customer details by pan id
		customerRepository.saveCustomerByPassword(passDetails.get("panId"),passDetails.get("password"));
	
		
		return new ResponseEntity<>("passwordReset approved",HttpStatus.ACCEPTED);
	}
	@PostMapping("/admin/requestApproval")
	public ResponseEntity<Object> requestApproval(@RequestBody Map<String,String> reqDetails){
		 // do customer details loan flag true
		customerRepository.saveLoanFlagByTrue(reqDetails.get("panId"),reqDetails.get("loanFlag"));
		
		
		return new ResponseEntity<>("requestAprroval completed",HttpStatus.ACCEPTED);
		
		//return null;
	}
	

@PostMapping("/admin/pendingLoans")
public ResponseEntity<Object> pendingLoans(@RequestBody Map<String,String> reqDetails){
	 // restemplate call /loanDetails of loan details
	
	String pendingUrl="https://localhost:9000/validate/pending/"+reqDetails.get("panId");
	List<PaymentHistory>  pp= (List<PaymentHistory>) restTemplate.getForObject(pendingUrl, PaymentHistory.class);
	long count =pp.stream().filter(e->!e.isPending()).count();
	// return fla=pp.streag count if true
	return ResponseEntity.ok(count);
	

	
//	return null;
}

@PostMapping("/admin/listLoans")
public ResponseEntity<Object> listLoans(@RequestBody Map<String,String> reqDetails){
	// restemplate call /loanDetails of loan details
	
		// return list of loan details
	String pendingUrl="https://localhost:9000/validate/loanDetails/"+reqDetails.get("panId");
	List<PaymentHistory>  pp= (List<PaymentHistory>) restTemplate.getForObject(pendingUrl, PaymentHistory.class);
	List<PaymentHistory> totalLoansApplied =pp.stream().collect(Collectors.toList());
	// return fla=pp.streag count if true
	return ResponseEntity.ok(totalLoansApplied);
	
	
//	return null;
}

}

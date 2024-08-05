package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.PaymentHistory;

public interface LoanRepository extends JpaRepository<PaymentHistory, String>{
   
	//void getAllPaymentHistoryByPanId(String pan);
	

}

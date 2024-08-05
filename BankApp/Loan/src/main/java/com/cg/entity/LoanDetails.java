package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoanDetails {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private String pan;
	private String loanType;
	private int amount;
	private boolean loanFag;
	
   
}

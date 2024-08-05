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
	
	public LoanDetails(String pan, String loanType, int amount, boolean loanFag) {
	
		this.pan = pan;
		this.loanType = loanType;
		this.amount = amount;
		this.loanFag = loanFag;
	}

	public LoanDetails() {
	
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isLoanFag() {
		return loanFag;
	}

	public void setLoanFag(boolean loanFag) {
		this.loanFag = loanFag;
	}
	
	

	@Override
	public String toString() {
		return "LoanDetails [pan=" + pan + ", loanType=" + loanType + ", amount=" + amount + ", loanFag=" + loanFag
				+ "]";
	}
	
   
}

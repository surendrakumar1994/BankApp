package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PaymentHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pan;
	
	
	
	public PaymentHistory(String pan, boolean pending) {
	
		this.pan = pan;
		this.pending = pending;
	}
	
	
	public PaymentHistory() {
		
		
	}


	private boolean pending;
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public boolean isPending() {
		return pending;
	}
	public void setPending(boolean pending) {
		this.pending = pending;
	}


	public Object getPropertyName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

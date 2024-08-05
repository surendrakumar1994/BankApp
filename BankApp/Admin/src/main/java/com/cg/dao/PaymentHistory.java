package com.cg.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class PaymentHistory {
	
	private String pan;
	private boolean pending;
	public PaymentHistory(String pan, boolean pending) {
		this.setPan(pan);
		this.setPending(pending);
	}
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
}

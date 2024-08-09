package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cibil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pan;
	private String score;
	private boolean low;
	public Cibil() {
		
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public boolean isLow() {
		return low;
	}
	public void setLow(boolean low) {
		this.low = low;
	}
	public Cibil(String pan, String score, boolean low) {
		
		this.pan = pan;
		this.score = score;
		this.low = low;
	}
	public Object getPropertyName() {
		// TODO Auto-generated method stub
		return null;
	}


}

package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EducationLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String panNo;
	private String name;
	private String Collecge;

	
	
	
	public EducationLoan() {
		
	}

	public EducationLoan(String panNo, String name, String collecge) {
		
		this.panNo = panNo;
		this.name = name;
		Collecge = collecge;
	}

	public String getCollecge() {
		return Collecge;
	}

	public void setCollecge(String collecge) {
		Collecge = collecge;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EducationLoan [panNo=" + panNo + ", name=" + name + ", Collecge=" + Collecge + "]";
	}

}

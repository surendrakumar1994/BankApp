package com.cg.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class EducationLoanDao {
	

     private String panNo;
     private String name;
     
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
     
     
}

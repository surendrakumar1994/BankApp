package com.cg.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class CustomerDao {
  
   private String panId;
   private String firstName;
   private String lastName;
   private boolean flag;//true/false
   private int listLoan;
   private int pendingLoans;
   
   
public String getPanId() {
	return panId;
}
public void setPanId(String panId) {
	this.panId = panId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public boolean isFlag() {
	return flag;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}
public int getListLoan() {
	return listLoan;
}
public void setListLoan(int listLoan) {
	this.listLoan = listLoan;
}
public int getPendingLoans() {
	return pendingLoans;
}
public void setPendingLoans(int pendingLoans) {
	this.pendingLoans = pendingLoans;
}
   
   
   
}

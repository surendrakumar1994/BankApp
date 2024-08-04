package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private String panId;
   private String firstName;
   private String lastName;
   private boolean loanFlag;
   private int listLoan;
   private int pendingLoans;
   private String password;
   
   
   
   
public Customer(String panId, String firstName, String lastName, boolean loanFlag, int listLoan, int pendingLoans,
		String password) {
	
	this.panId = panId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.loanFlag = loanFlag;
	this.listLoan = listLoan;
	this.pendingLoans = pendingLoans;
	this.password = password;
}




public Customer() {
	super();
	// TODO Auto-generated constructor stub
}




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
public boolean isLoanFlag() {
	return loanFlag;
}
public void setLoanFlag(boolean loanFlag) {
	this.loanFlag = loanFlag;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}




@Override
public String toString() {
	return "Customer [panId=" + panId + ", firstName=" + firstName + ", lastName=" + lastName + ", loanFlag=" + loanFlag
			+ ", listLoan=" + listLoan + ", pendingLoans=" + pendingLoans + ", password=" + password + "]";
}
   
   
   
   
}

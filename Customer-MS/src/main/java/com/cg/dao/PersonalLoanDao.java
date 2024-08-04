package com.cg.dao;



public class PersonalLoanDao {

	private String panNo;
	
	private double  amount;
	private String name;
	private String business;
	
	public PersonalLoanDao() {
		
	}
	public PersonalLoanDao(String panNo, double amount, String name, String business) {
		
		this.panNo = panNo;
		this.amount = amount;
		this.name = name;
		this.business = business;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	@Override
	public String toString() {
		return "PersonalLoan [panNo=" + panNo + ", amount=" + amount + ", name=" + name + ", business=" + business
				+ "]";
	}
	
}

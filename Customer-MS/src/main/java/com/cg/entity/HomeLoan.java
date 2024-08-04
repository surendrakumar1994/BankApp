package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HomeLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String panNo;
	private String Name;
	private String address;
	
	
	
	public HomeLoan() {

	}
	public HomeLoan(String panNo, String name, String address) {

		this.panNo = panNo;
		this.Name = name;
		this.address = address;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "HomeLoan [panNo=" + panNo + ", Name=" + Name + ", address=" + address + "]";
	}
	
	
}

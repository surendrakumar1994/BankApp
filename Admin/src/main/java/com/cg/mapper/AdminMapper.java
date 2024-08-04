package com.cg.mapper;

import com.cg.dao.CustomerDao;

import com.cg.entity.Customer;


public class AdminMapper {

	
	  public static CustomerDao custToDAO(Customer cust) {
	        if (cust == null) {
	            return null;
	        }
	        CustomerDao cdao = new  CustomerDao();
	        cdao.setPanId(cust.getPanId());
	        cdao.setFirstName(cust.getFirstName());
	        cdao.setLastName(cust.getLastName());
	        cdao.setPendingLoans(cust.getPendingLoans());
	        cdao.setListLoan(cust.getListLoan());
	        return cdao;
	    }

	    public static Customer toEntity(CustomerDao custDAO) {
	        if (custDAO == null) {
	            return null;
	        }
	         Customer cEntity = new  Customer ();
	        cEntity.setPanId(custDAO.getPanId());
	        cEntity.setFirstName(custDAO.getFirstName());
	        cEntity.setLastName(custDAO.getLastName());
	        cEntity.setListLoan(custDAO.getListLoan());
	        cEntity.setPendingLoans(custDAO.getPendingLoans());
	        return cEntity;
	    }
}

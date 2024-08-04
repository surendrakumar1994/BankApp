package com.cg.mapper;

import com.cg.dao.EducationLoanDao;
import com.cg.dao.HomeLoanDao;
import com.cg.dao.PersonalLoanDao;
import com.cg.entity.EducationLoan;
import com.cg.entity.HomeLoan;
import com.cg.entity.PersonalLoan;

public class CustomerMapper {

	// Education Loan
    public static EducationLoanDao eduToDAO(EducationLoan edu) {
        if (edu == null) {
            return null;
        }
        EducationLoanDao dao = new  EducationLoanDao();
        dao.setPanNo(edu.getPanNo());
        dao.setName(edu.getName());
        
        return dao;
    }

    public static EducationLoan toEntity(EducationLoanDao eduDAO) {
        if (eduDAO == null) {
            return null;
        }
        EducationLoan eduEntity = new  EducationLoan ();
        eduEntity.setPanNo(eduDAO.getPanNo());
        eduEntity.setName(eduDAO.getName());
      
        return eduEntity;
    }
    
    
    //Home Loan
    public static HomeLoanDao homeToDAO(HomeLoan home) {
        if (home == null) {
            return null;
        }
        HomeLoanDao hmedao = new  HomeLoanDao();
        hmedao.setPanNo(home.getPanNo());
        hmedao.setName(home.getName());
        
        return  hmedao;
    }

    public static HomeLoan toEntity(HomeLoanDao homeDAO) {
        if (homeDAO == null) {
            return null;
        }
        HomeLoan homeEntity = new  HomeLoan ();
        homeEntity.setPanNo(homeDAO.getPanNo());
        homeEntity.setName(homeDAO.getName());
        homeEntity.setAddress(homeDAO.getAddress());
      
        return homeEntity;
    }
    
    //Personal Loan
    
    public static PersonalLoanDao personalToDAO(PersonalLoan personal) {
        if (personal == null) {
            return null;
        }
        PersonalLoanDao prsnldao = new  PersonalLoanDao();
        prsnldao .setPanNo(personal.getPanNo());
        prsnldao .setName(personal.getName());
        prsnldao .setBusiness(personal.getBusiness());
        prsnldao .setAmount(personal.getAmount());
        
        return   prsnldao;
    }

    public static PersonalLoan toEntity(PersonalLoanDao personDAO) {
        if (personDAO == null) {
            return null;
        }
        PersonalLoan personEntity = new  PersonalLoan ();
        personEntity.setPanNo(personDAO.getPanNo());
        personEntity.setName(personDAO.getName());
        personEntity.setBusiness(personDAO.getBusiness());
        personEntity.setAmount(personDAO.getAmount());
        return personEntity;
    }

	
    
}

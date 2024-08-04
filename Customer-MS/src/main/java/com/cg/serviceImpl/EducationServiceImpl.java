package com.cg.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.EducationLoanDao;
import com.cg.entity.EducationLoan;
import com.cg.mapper.CustomerMapper;
import com.cg.repo.EducationRepo;
import com.cg.service.EducationSERVICE;

@Service
public class EducationServiceImpl implements EducationSERVICE {

	@Autowired
	private EducationRepo eductionrepo;
	
	 public EducationLoanDao applyEducationLoan(EducationLoanDao loanRequest) {
		    EducationLoan eduLoan=CustomerMapper.toEntity(loanRequest);
		    
		    	EducationLoan edu= eductionrepo.save(eduLoan);
		    	return CustomerMapper.eduToDAO(edu);
		   
	    }

	
}

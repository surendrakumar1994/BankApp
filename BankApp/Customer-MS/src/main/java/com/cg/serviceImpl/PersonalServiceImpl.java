package com.cg.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.EducationLoanDao;
import com.cg.dao.PersonalLoanDao;
import com.cg.entity.EducationLoan;
import com.cg.entity.PersonalLoan;
import com.cg.mapper.CustomerMapper;
import com.cg.repo.EducationRepo;
import com.cg.repo.PersonalLoanRepo;

@Service
public class PersonalServiceImpl {

	
	@Autowired
	private PersonalLoanRepo personalrepo;
	
	 public PersonalLoanDao applyPersonalLoan(PersonalLoanDao loanRequest) {
		    PersonalLoan personalLoan=CustomerMapper.toEntity(loanRequest);
		    
		    PersonalLoan personal= personalrepo.save(personalLoan);
		    	return CustomerMapper.personalToDAO(personal);
		   
	    }

	   
	
}

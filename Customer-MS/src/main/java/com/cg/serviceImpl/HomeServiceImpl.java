package com.cg.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.HomeLoanDao;
import com.cg.entity.EducationLoan;
import com.cg.entity.HomeLoan;
import com.cg.mapper.CustomerMapper;
import com.cg.repo.HomeRepo;

@Service
public class HomeServiceImpl {

	@Autowired
	private HomeRepo homeRepo;
	
	public HomeLoanDao applyHomeLoan(HomeLoanDao loanRequest) {
		
		HomeLoan hmeLoan=CustomerMapper.toEntity(loanRequest);
		    
	    	HomeLoan hme= homeRepo.save(hmeLoan);
	    	return CustomerMapper.homeToDAO(hme);
	   
  }

 
}

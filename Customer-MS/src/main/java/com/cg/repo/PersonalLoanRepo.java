package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.PersonalLoan;

public interface PersonalLoanRepo extends JpaRepository<PersonalLoan, String>{

}

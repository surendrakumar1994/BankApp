package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.EducationLoan;

public interface EducationRepo extends JpaRepository<EducationLoan,String>{

}

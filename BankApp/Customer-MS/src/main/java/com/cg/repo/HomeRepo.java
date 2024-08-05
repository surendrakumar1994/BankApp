package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.HomeLoan;

public interface HomeRepo extends JpaRepository<HomeLoan, String>{

}

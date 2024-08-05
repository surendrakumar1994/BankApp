package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	
    @Query(value="UPDATE CUSTOMER SET loanFlag =:approveReject WHERE panId=:panId", nativeQuery = true)
	void saveByPanId(@Param(value = "panId") String panId,@Param(value = "approveReject") boolean approveReject);
    
    
    @Query(value="UPDATE CUSTOMER SET password =:pass WHERE panId=:panId", nativeQuery = true)
	void saveCustomerByPassword(@Param(value="panId")String panId,@Param(value="pass") String pass);

    @Query(value="UPDATE CUSTOMER SET loanFlag =:loanFlag WHERE panId=:panId", nativeQuery = true)
	void saveLoanFlagByTrue(@Param(value="panId")String panId,@Param(value="loanFlag") String loanFlag);


}

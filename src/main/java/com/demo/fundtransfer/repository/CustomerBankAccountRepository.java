package com.demo.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.fundtransfer.model.CustomerBankAccount;

@Repository
public interface CustomerBankAccountRepository extends JpaRepository<CustomerBankAccount, Long> {

	CustomerBankAccount findByAccountNo(Long fromAccount);
	CustomerBankAccount findByAccountNoOrIfscCode(Long fromAccount, String ifsc );

}

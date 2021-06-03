package com.demo.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.fundtransfer.model.Beneficiary;
import com.demo.fundtransfer.model.CustomerBankAccount;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

	Beneficiary findByBaccountNo(Long fromAccount);

	Beneficiary findByBaccountNoOrIfscCode(long accountNo, String ifscCode);
	
	Beneficiary findByBaccountNoAndAccount(long bAccount, CustomerBankAccount account);

}

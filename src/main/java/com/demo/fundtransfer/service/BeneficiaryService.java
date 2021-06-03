package com.demo.fundtransfer.service;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.fundtransfer.exception.CommonException;
import com.demo.fundtransfer.model.Beneficiary;
import com.demo.fundtransfer.model.BeneficiaryDto;
import com.demo.fundtransfer.model.CustomerBankAccount;
import com.demo.fundtransfer.repository.BeneficiaryRepository;
import com.demo.fundtransfer.repository.CustomerBankAccountRepository;

@Service
public class BeneficiaryService {

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Autowired
	CustomerBankAccountRepository bankAccountRepository;

	Beneficiary beneficiary = new Beneficiary();

	public BeneficiaryDto addBeneficiary(BeneficiaryDto beneficiaryDto) {

		BeanUtils.copyProperties(beneficiaryDto, beneficiary);

		CustomerBankAccount bankAccount = bankAccountRepository.findByAccountNo(beneficiaryDto.getAccountNo());

		if (bankAccount != null) {

			beneficiary.setAccount(bankAccount);
		} else {
			throw new CommonException("Bank Account Dose not Exists");
		}

		if (beneficiaryRepository.findByBaccountNoOrIfscCode(beneficiary.getAccountNo(),
				beneficiary.getIfscCode()) == null)

		{
			beneficiary.setbAmount(new BigDecimal(3000));
			beneficiaryRepository.save(beneficiary);
		} else {
			throw new CommonException(" Beneficiary Already Exists");
		}

		return beneficiaryDto;
	}

}

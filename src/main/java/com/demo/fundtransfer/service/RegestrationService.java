package com.demo.fundtransfer.service;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.fundtransfer.exception.CommonException;
import com.demo.fundtransfer.model.Customer;
import com.demo.fundtransfer.model.CustomerBankAccount;
import com.demo.fundtransfer.model.CustomerDto;
import com.demo.fundtransfer.repository.CustomerBankAccountRepository;
import com.demo.fundtransfer.repository.LoginRepository;

@Service
public class RegestrationService {

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	CustomerBankAccountRepository accountRepository;

	Customer customer = new Customer();
	CustomerBankAccount account = new CustomerBankAccount();

	public CustomerDto registerCustomer(CustomerDto customerDto) throws CommonException {

		BeanUtils.copyProperties(customerDto, customer);

		if (loginRepository.findByUserNameAndPassword(customer.getUserName(), customer.getPassword()).isPresent()) {
			throw new CommonException("Duplicate Entry of Username and Password");
		}

		account.setAccountType("Savings");
		account.setOpeningBalance(new BigDecimal(3000));
		account.setTotalBalance(new BigDecimal(3000));
		account.setIfscCode("ifsc" + "0000" + (10000 + Math.random() * 90000));

		CustomerBankAccount bankaccount = accountRepository.save(account);
		customer.setCustomeraccount(bankaccount);
		loginRepository.save(customer);
		return customerDto;
	}

	public CustomerDto updateCustomer(CustomerDto customerDto) {
		BeanUtils.copyProperties(customerDto, customer);
		loginRepository.save(customer);
		return customerDto;
	}

}

package com.demo.fundtransfer.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.fundtransfer.exception.AccountNotFoundException;
import com.demo.fundtransfer.model.Beneficiary;
import com.demo.fundtransfer.model.CustomerBankAccount;
import com.demo.fundtransfer.model.TransactionDetails;
import com.demo.fundtransfer.repository.BeneficiaryRepository;
import com.demo.fundtransfer.repository.CustomerBankAccountRepository;
import com.demo.fundtransfer.repository.LoginRepository;
import com.demo.fundtransfer.repository.TransactionDetailsRepository;

@Service
public class TransactionDetailsService {

	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;

	@Autowired
	CustomerBankAccountRepository accountRepository;

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Autowired
	LoginRepository loginRepository;

	CustomerBankAccount account = new CustomerBankAccount();

	public TransactionDetails makeTransaction(TransactionDetails transactionDetails) throws AccountNotFoundException {

		Long fromaccount = transactionDetails.getFromAccount();
		Long toaccount = transactionDetails.getToAccount();

		CustomerBankAccount accountdebit = accountRepository.findByAccountNo(fromaccount);
		Beneficiary accountcredit = beneficiaryRepository.findByBaccountNo(toaccount);

		if (beneficiaryRepository.findByBaccountNoAndAccount(toaccount, accountdebit) == null) {
			throw new AccountNotFoundException("Please add Beneficiary");
		}

		if (accountdebit == null || accountcredit == null) {
			throw new AccountNotFoundException("Beneficiary dosent Exists");
		}

		if (fromaccount == toaccount) {
			throw new AccountNotFoundException("To & From Account Cannot be Same");
		}

		BigDecimal fromAccount_TotalBalance = accountdebit.getTotalBalance();
		BigDecimal toAccount_TotalBalance = accountcredit.getbAmount();
		BigDecimal transactionAmount = transactionDetails.getTransactionAmount();

		if (transactionAmount.compareTo(fromAccount_TotalBalance) == 1) {
			throw new AccountNotFoundException("entered Amount should be less than total balance");
		}

		fromAccount_TotalBalance = fromAccount_TotalBalance.subtract(transactionAmount);
		toAccount_TotalBalance = toAccount_TotalBalance.add(transactionAmount);

		accountdebit.setTotalBalance(fromAccount_TotalBalance);
		accountcredit.setbAmount(toAccount_TotalBalance);

		accountRepository.save(accountdebit);
		beneficiaryRepository.save(accountcredit);
		return transactionDetailsRepository.save(transactionDetails);

		/*
		 * ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		 * responseMessageDto.setMessage("Transaction done Sucessfully");
		 */

	}

}

package com.demo.fundtransfer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fundtransfer.exception.AccountNotFoundException;
import com.demo.fundtransfer.model.TransactionDetails;
import com.demo.fundtransfer.service.TransactionDetailsService;

@RestController
public class TransactionDetailsController {

	@Autowired
	TransactionDetailsService service;
	Logger logger = LoggerFactory.getLogger(TransactionDetailsController.class);

	@PostMapping("/fund")
	public TransactionDetails fundTransferCall(@Valid @RequestBody TransactionDetails fundtransfer)
			throws AccountNotFoundException {
		return service.makeTransaction(fundtransfer);

	}

}

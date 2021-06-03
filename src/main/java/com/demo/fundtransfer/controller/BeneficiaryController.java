package com.demo.fundtransfer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fundtransfer.model.BeneficiaryDto;
import com.demo.fundtransfer.service.BeneficiaryService;

@RestController
public class BeneficiaryController {
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@PostMapping("/beneficiary")
	public ResponseEntity<BeneficiaryDto> addBenenficiary(@Valid @RequestBody BeneficiaryDto beneficiary)
	{
		beneficiaryService.addBeneficiary(beneficiary);
		return new ResponseEntity<BeneficiaryDto>(beneficiary, HttpStatus.OK);
	}

}

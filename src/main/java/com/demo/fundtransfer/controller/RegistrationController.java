
package com.demo.fundtransfer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fundtransfer.exception.CommonException;
import com.demo.fundtransfer.model.CustomerDto;
import com.demo.fundtransfer.service.RegestrationService;

@RestController
public class RegistrationController {

	@Autowired
	RegestrationService registration;

	@PostMapping("/add")
	public ResponseEntity<CustomerDto> registration(@Valid @RequestBody CustomerDto customerDto)
			throws CommonException {

		registration.registerCustomer(customerDto);

		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customer)
			throws CommonException{

		registration.updateCustomer(customer);

		return new ResponseEntity<CustomerDto>(customer, HttpStatus.OK);

	}
}

package com.demo.fundtransfer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fundtransfer.exception.UserNotFoundException;
import com.demo.fundtransfer.model.LoginDto;
import com.demo.fundtransfer.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	Logger logger = LoggerFactory.getLogger(TransactionDetailsController.class);

	@PostMapping("/login")
	public String login(@Valid @RequestBody LoginDto customerDto) throws UserNotFoundException {
		logger.info("<<------------In login Method------------>>");
		return loginService.loginCheck(customerDto.getUserName(),customerDto.getPassword());

	}

}

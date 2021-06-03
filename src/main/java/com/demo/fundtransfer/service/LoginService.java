package com.demo.fundtransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.fundtransfer.exception.UserNotFoundException;
import com.demo.fundtransfer.model.Customer;
import com.demo.fundtransfer.model.LoginDto;
import com.demo.fundtransfer.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	Customer customer = new Customer();

	public String loginCheck(String username, String password) throws UserNotFoundException {

		if (loginRepository.findByUserNameAndPassword(customer.getUserName(), customer.getPassword()).isPresent()) {

			return "user Logged in Sucessfully";

		} else {
			throw new UserNotFoundException("User is Not Present");

		}

	}

}

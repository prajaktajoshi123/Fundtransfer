package com.demo.fundtransfer.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.fundtransfer.controller.LoginController;
import com.demo.fundtransfer.exception.UserNotFoundException;
import com.demo.fundtransfer.model.Customer;
import com.demo.fundtransfer.model.CustomerDto;
import com.demo.fundtransfer.model.LoginDto;
import com.demo.fundtransfer.service.LoginService;
import com.demo.fundtransfer.service.RegestrationService;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	RegestrationService service;

	@Mock
	LoginService loginservice;

	Customer customer;

	CustomerDto customerDto;

	LoginDto loginDto;

	LoginDto loginDto1;

	// @Test
	// public void loginCustomerPositiveTest() throws Exception

	@Test
	@DisplayName("Login Function: Positive Scenario")
	public void loginTest() throws UserNotFoundException {

		loginDto = new LoginDto();
		loginDto.setUserName("p");
		loginDto.setPassword("p");

		// context
		when(loginservice.loginCheck("p", "p")).thenReturn("Login success");

		// event
		String result = loginController.login(loginDto);

		// outcome
		assertEquals("Login success", result);
	}

	@Test
	@DisplayName("Login Function: Negative Scenario")
	public void loginTest2() {
		
		loginDto = new LoginDto();
		loginDto.setUserName("p");
		loginDto.setPassword("p");
		//context
		when(loginservice.loginCheck("p", "p")).thenThrow(UserNotFoundException.class);
		
		//event
		//outcome
		assertThrows(UserNotFoundException.class, ()->loginController.login(loginDto));
	}
}

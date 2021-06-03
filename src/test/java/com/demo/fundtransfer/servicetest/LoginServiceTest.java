//
//package com.demo.fundtransfer.servicetest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.demo.fundtransfer.model.Beneficiary;
//import com.demo.fundtransfer.model.Customer;
//import com.demo.fundtransfer.model.CustomerBankAccount;
//import com.demo.fundtransfer.repository.LoginRepository;
//import com.demo.fundtransfer.service.LoginService;
//import com.google.common.base.Optional;
//
//@ExtendWith(MockitoExtension.class)
//public class LoginServiceTest {
//
//	@Mock
//	LoginRepository login;
//
//	@InjectMocks
//	LoginService loginservice;
//
//	static Optional<Customer> customer;
//
//	static CustomerBankAccount account;
//
//	static Beneficiary beneficiary;
//
//	@Test
//	@DisplayName("authentication : positive scenario")
//	public void authenticationTest() { // context
//
//		Customer customer1 = new Customer();
//
//		customer1.setPassword("p");
//		customer1.setUserName("p");
//
//		when(login.findByUserNameAndPassword("anu", "1234")).thenReturn(customer);
//
//		// event
//		String result = loginservice.loginCheck("anu", "1234");
//
//		// outcome
//		assertEquals("Login success", result);
//	}
//
////	@Test
////	@DisplayName("authentication : negative scenario")
////	public void authenticationTest1() { // context
////		when(userDao.findByUserNameAndPassword("anu", "1234")).thenReturn(null);
////
////		// event and outcome
////		assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.authenticate("anu", "1234"));
////
////	}
//}
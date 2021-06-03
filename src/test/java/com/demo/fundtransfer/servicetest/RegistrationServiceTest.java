//
//package com.demo.fundtransfer.servicetest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.demo.fundtransfer.exception.UserNotFoundException;
//import com.demo.fundtransfer.model.Beneficiary;
//import com.demo.fundtransfer.model.Customer;
//import com.demo.fundtransfer.model.CustomerBankAccount;
//import com.demo.fundtransfer.model.CustomerDto;
//import com.demo.fundtransfer.repository.CustomerBankAccountRepository;
//import com.demo.fundtransfer.repository.LoginRepository;
//import com.demo.fundtransfer.service.RegestrationService;
//import com.google.common.base.Optional;
//
//@ExtendWith(MockitoExtension.class)
//public class RegistrationServiceTest {
//
//	@MockBean
//	LoginRepository loginRepository;
//	
//	@MockBean
//	CustomerBankAccountRepository accountRepository;
//
//	@InjectMocks
//	RegestrationService regestrationService;
//
//	Customer customer;
//
//	CustomerBankAccount account;
//
//	Beneficiary beneficiary;
//	
//	CustomerDto customerDto;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	
//	@Test
//	public void addCustomerPositiveTest() throws Exception {
//
////		String mockContent = "{\r\n" + "  \"address\": \"Pune\",\r\n" + "  \"customerId\": 1,\r\n"
////				+ "  \"emailId\": \"p@gmail.com\",\r\n" + "  \"firstName\": \"Prajakta\",\r\n"
////				+ "  \"lastName\": \"Joshi\",\r\n" + "  \"mobileNumber\": 98765678765,\r\n"
////				+ "  \"openingBalance\": 10000,\r\n" + "  \"panNumber\": \"yhjkr67\",\r\n"
////				+ "  \"password\": \"p\",\r\n" + "  \"userName\": \"p\"\r\n" + "}";
//
//		account = new CustomerBankAccount();
//		account.setAccountNo(0);
//		account.setAccountType("Savings");
//		account.setIfscCode("icici");
//		account.setOpeningBalance(new BigDecimal(1000));
//		account.setTotalBalance(new BigDecimal(1000));
//		
//		//Optional<Customer> cust ;
//		
//		customer = new Customer();
//		customer.setAddress("Pune");
//		customer.setCustomeraccount(account);
//		customer.setCustomerId(1);
//		customer.setEmailId("p@gmail.com");
//		customer.setFirstName("Prajakta");
//		customer.setLastName("Joshi");
//		customer.setMobileNumber(8764567876l);
//		customer.setPanNumber("765dfghj");
//		customer.setPassword("p");
//		customer.setUserName("p");
//		
//		customerDto = new CustomerDto();
//		customerDto.setAddress("Addfress");
//		customerDto.setCustomerId(1);
//		customerDto.setEmailId("p@gmail.com");
//		customerDto.setFirstName("Prajakta");
//		customerDto.setLastName("Joshi");
//		customerDto.setMobileNumber(9876545678l);
//		customerDto.setOpeningBalance(new BigDecimal(1000));
//		customerDto.setPanNumber("iuyt8756");
//		customerDto.setPassword("p");
//		customerDto.setUserName("p");
//
//		Mockito.when(loginRepository.save(customer)).thenReturn(customer);
////		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add").accept(MediaType.APPLICATION_JSON)
////				.content(mockContent).contentType(MediaType.APPLICATION_JSON);
////		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////		MockHttpServletResponse response = result.getResponse();
//		assertEquals(customer, loginRepository.save(customer));
//		
//
//}
////
////	@Test
////	public void addCustomerNegativeTest() throws Exception {
////
////		String errExpected = "{\r\n" + "  \"message\": \"Duplicate Entry of Username and Password\",\r\n"
////				+ "  \"httpCodeMessage\": \"NOT_FOUND\"\r\n" + "}";
////
////		String mockContent = "{\r\n" + "  \"address\": \"Pune\",\r\n" + "  \"customerId\": 1,\r\n"
////				+ "  \"emailId\": \"p@gmail.com\",\r\n" + "  \"firstName\": \"Prajakta\",\r\n"
////				+ "  \"lastName\": \"Joshi\",\r\n" + "  \"mobileNumber\": 98765678765,\r\n"
////				+ "  \"openingBalance\": 10000,\r\n" + "  \"panNumber\": \"yhjkr67\",\r\n"
////				+ "  \"password\": \"p\",\r\n" + "  \"userName\": \"p\"\r\n" + "}";
////
////		UserNotFoundException exception = new UserNotFoundException("Duplicate Entry of Username and Password");
////		Mockito.when(service.registerCustomer(Mockito.any(CustomerDto.class))).thenThrow(exception);
////		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add").accept(MediaType.APPLICATION_JSON)
////				.content(mockContent).contentType(MediaType.APPLICATION_JSON);
////		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////		MockHttpServletResponse response = result.getResponse();
////		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
////		JSONAssert.assertEquals(errExpected, result.getResponse().getContentAsString(), false);
////	}
////
////	@Test
////	public void updateCustomerPositiveTest() throws Exception {
////
////		String mockContent = "{\r\n" + "  \"address\": \"Pune\",\r\n" + "  \"customerId\": 1,\r\n"
////				+ "  \"emailId\": \"p@gmail.com\",\r\n" + "  \"firstName\": \"Prajakta\",\r\n"
////				+ "  \"lastName\": \"Joshi\",\r\n" + "  \"mobileNumber\": 98765678745,\r\n"
////				+ "  \"openingBalance\": 1000,\r\n" + "  \"panNumber\": \"ytfg7656\",\r\n"
////				+ "  \"password\": \"p\",\r\n" + "  \"userName\": \"p\"\r\n" + "}";
////
////		customerDto = new CustomerDto();
////		customerDto.setAddress("Addfress");
////		customerDto.setCustomerId(1);
////		customerDto.setEmailId("p@gmail.com");
////		customerDto.setFirstName("Prajakta");
////		customerDto.setLastName("Joshi");
////		customerDto.setMobileNumber(9876545678l);
////		customerDto.setOpeningBalance(new BigDecimal(1000));
////		customerDto.setPanNumber("iuyt8756");
////		customerDto.setPassword("p");
////		customerDto.setUserName("p");
////
////		Mockito.when(service.updateCustomer(Mockito.any(CustomerDto.class))).thenReturn(customerDto);
////		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update").accept(MediaType.APPLICATION_JSON)
////				.content(mockContent).contentType(MediaType.APPLICATION_JSON);
////		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////		MockHttpServletResponse response = result.getResponse();
////		assertEquals(HttpStatus.OK.value(), response.getStatus());
////		JSONAssert.assertEquals(mockContent, result.getResponse().getContentAsString(), false);
////
////	}
////
////	@Test
////	public void updateCustomerNegativeTest() throws Exception {
////
////		String errExpected = "{\r\n" + "  \"message\": \"User Not Found\",\r\n"
////				+ "  \"httpCodeMessage\": \"NOT_FOUND\"\r\n" + "}";
////
////		String mockContent = "{\r\n" + "  \"address\": \"Pune\",\r\n" + "  \"customerId\": 1,\r\n"
////				+ "  \"emailId\": \"p@gmail.com\",\r\n" + "  \"firstName\": \"Prajakta\",\r\n"
////				+ "  \"lastName\": \"Joshi\",\r\n" + "  \"mobileNumber\": 98765678765,\r\n"
////				+ "  \"openingBalance\": 10000,\r\n" + "  \"panNumber\": \"yhjkr67\",\r\n"
////				+ "  \"password\": \"p\",\r\n" + "  \"userName\": \"p\"\r\n" + "}";
////
////		UserNotFoundException exception = new UserNotFoundException("User Not Found");
////		Mockito.when(service.updateCustomer(Mockito.any(CustomerDto.class))).thenThrow(exception);
////		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update").accept(MediaType.APPLICATION_JSON)
////				.content(mockContent).contentType(MediaType.APPLICATION_JSON);
////		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////		MockHttpServletResponse response = result.getResponse();
////		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
////		JSONAssert.assertEquals(errExpected, result.getResponse().getContentAsString(), false);
////	}
//
//}

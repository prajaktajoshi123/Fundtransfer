package com.demo.fundtransfer.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.fundtransfer.controller.BeneficiaryController;
import com.demo.fundtransfer.exception.CommonException;
import com.demo.fundtransfer.exception.UserNotFoundException;
import com.demo.fundtransfer.model.BeneficiaryDto;
import com.demo.fundtransfer.model.CustomerDto;
import com.demo.fundtransfer.service.BeneficiaryService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = BeneficiaryController.class)
public class BeneficiaryControllerTest {

	@MockBean
	BeneficiaryService beneficiaryService;

	@InjectMocks
	BeneficiaryController beneficiaryController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void addBeneficiaryPositiveTest() throws Exception {

		String mockContent = "{\r\n" + "  \"accountNo\": 2001,\r\n" + "  \"bAmount\": 1000,\r\n"
				+ "  \"bFirstName\": \"Prajakta\",\r\n" + "  \"bLastName\": \"Joshi\",\r\n" + "  \"baccountNo\": 1001,\r\n"
				+ "  \"ifscCode\": \"hjj788767\"\r\n" + "}";

		BeneficiaryDto beneficiaryDto = new BeneficiaryDto();
		beneficiaryDto.setAccountNo(1001);
		beneficiaryDto.setBaccountNo(2001);
		beneficiaryDto.setbAmount(new BigDecimal(1000));
		beneficiaryDto.setbFirstName("Prajakta");
		beneficiaryDto.setbLastName("Joshi");
		beneficiaryDto.setIfscCode("98756hgdfg");

		Mockito.when(beneficiaryService.addBeneficiary(Mockito.any(BeneficiaryDto.class))).thenReturn(beneficiaryDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/beneficiary").accept(MediaType.APPLICATION_JSON)
				.content(mockContent).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		JSONAssert.assertEquals(mockContent, result.getResponse().getContentAsString(), false);

	}

//	@Test
//	public void addBeneficiaryNegativeTest() throws Exception {
//
//		String errExpected = "{\r\n"
//				+ "  \"message\": \"Bank Account Dose not Exists\",\r\n"
//				+ "  \"httpCodeMessage\": \"NOT_FOUND\"\r\n"
//				+ "}";
//
//		String mockContent = "{\r\n" + "  \"accountNo\": 2001,\r\n" + "  \"bAmount\": 1000,\r\n"
//				+ "  \"bFirstName\": \"Prajakta\",\r\n" + "  \"bLastName\": \"Joshi\",\r\n" + "  \"baccountNo\": 1001,\r\n"
//				+ "  \"ifscCode\": \"hjj788767\"\r\n" + "}";
//
//		
//
//		CommonException exception = new CommonException("Bank Account Does not Exists");
//		Mockito.when(beneficiaryService.addBeneficiary(Mockito.any(BeneficiaryDto.class))).thenThrow(exception);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/beneficiary").accept(MediaType.APPLICATION_JSON)
//				.content(mockContent).contentType(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
//		JSONAssert.assertEquals(errExpected, result.getResponse().getContentAsString(), false);
//	}
}

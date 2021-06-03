package com.demo.fundtransfer.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

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

import com.demo.fundtransfer.controller.TransactionDetailsController;
import com.demo.fundtransfer.exception.CommonException;
import com.demo.fundtransfer.model.TransactionDetails;
import com.demo.fundtransfer.repository.TransactionDetailsRepository;
import com.demo.fundtransfer.service.TransactionDetailsService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TransactionDetailsController.class)
public class TransactionDetailsControllerTest {

	@MockBean
	TransactionDetailsRepository detailsRepository;

	@MockBean
	TransactionDetailsService detailsService;

	@InjectMocks
	TransactionDetailsController detailController;

	@Autowired
	private MockMvc mockMvc;

	TransactionDetails transactionDetails;

	@Test
	public void doTransactionPositiveTest() throws Exception {

		String mockContent = "{\r\n" + "  \"fromAccount\": 1001,\r\n" + "  \"id\": 1,\r\n"
				+ "  \"remarks\": \"foodwallet\",\r\n" + "  \"toAccount\": 2001,\r\n"
				+ "  \"transactionAmount\": 1000,\r\n" + "  \"transactionDate\": \"2021-06-03\"\r\n" + "}";

		transactionDetails = new TransactionDetails();
		transactionDetails.setFromAccount(1001);
		transactionDetails.setId(1l);
		transactionDetails.setRemarks("foodwallet");
		transactionDetails.setToAccount(2001);
		transactionDetails.setTransactionAmount(new BigDecimal(1000));
		transactionDetails.setTransactionDate(LocalDate.now());

		Mockito.when(detailsService.makeTransaction(Mockito.any(TransactionDetails.class)))
				.thenReturn(transactionDetails);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/fund").accept(MediaType.APPLICATION_JSON)
				.content(mockContent).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		JSONAssert.assertEquals(mockContent, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void doTransactionNegativeTest() throws Exception {

		String mockContent = "{\r\n" + "  \"message\": \"Please add Beneficiary\",\r\n"
				+ "  \"httpCodeMessage\": \"NOT_FOUND\"\r\n" + "}";

		transactionDetails = new TransactionDetails();
		transactionDetails.setFromAccount(1001);
		transactionDetails.setId(1l);
		transactionDetails.setRemarks("foodwallet");
		transactionDetails.setToAccount(2001);
		transactionDetails.setTransactionAmount(new BigDecimal(1000));
		transactionDetails.setTransactionDate(LocalDate.now());

		CommonException exception = new CommonException("Please add Beneficiary");
		Mockito.when(detailsService.makeTransaction(Mockito.any(TransactionDetails.class))).thenThrow(exception);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/fund").accept(MediaType.APPLICATION_JSON)
				.content(mockContent).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
		JSONAssert.assertEquals(mockContent, result.getResponse().getContentAsString(), false);

	}

}

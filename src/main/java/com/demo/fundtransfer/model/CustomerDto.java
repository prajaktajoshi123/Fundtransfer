package com.demo.fundtransfer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerDto {
	
	
	
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long customerId;

	@Column
	@NotNull
	@NotEmpty(message = "Password should not be null")
	private String userName;

	@Column
	@NotNull
	@NotEmpty(message = "Password should not be null")
	private String password;

	@Column(nullable = false, length = 23)
	private String firstName;

	@Column(nullable = false, length = 23)
	private String lastName;

	@Column(nullable = false, length = 23)
	private String address;

	@Column(nullable = false, length = 23)
	private long mobileNumber;

	@Column(nullable = false, length = 23)
	@Email
	private String emailId;

	@Column
	(nullable = false, length = 23)
	private String panNumber;
	
	@Column
	(nullable = false, length = 23)
	private BigDecimal openingBalance;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	
}

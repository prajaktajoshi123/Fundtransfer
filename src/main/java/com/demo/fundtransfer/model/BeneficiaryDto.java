package com.demo.fundtransfer.model;

import java.math.BigDecimal;

public class BeneficiaryDto {

	private long baccountNo;
	
	private long accountNo;

	private String ifscCode;

	private String bFirstName;

	private String bLastName;

	private BigDecimal bAmount;

	public long getBaccountNo() {
		return baccountNo;
	}

	public void setBaccountNo(long baccountNo) {
		this.baccountNo = baccountNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getbFirstName() {
		return bFirstName;
	}

	public void setbFirstName(String bFirstName) {
		this.bFirstName = bFirstName;
	}

	public String getbLastName() {
		return bLastName;
	}

	public void setbLastName(String bLastName) {
		this.bLastName = bLastName;
	}

	public BigDecimal getbAmount() {
		return bAmount;
	}

	public void setbAmount(BigDecimal bAmount) {
		this.bAmount = bAmount;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	

}

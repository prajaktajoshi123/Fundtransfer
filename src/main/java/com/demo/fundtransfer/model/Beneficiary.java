package com.demo.fundtransfer.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Beneficiary {

	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long beneficiaryId;

	@Column
	private long baccountNo;

	@Column
	private String ifscCode;

	@Column
	private String bFirstName;

	@Column
	private String bLastName;

	@Column
	private BigDecimal bAmount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_no")
	private CustomerBankAccount account;

	public long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public long getAccountNo() {
		return baccountNo;
	}

	public void setAccountNo(long accountNo) {
		this.baccountNo = accountNo;
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

	public CustomerBankAccount getAccount() {
		return account;
	}

	public void setAccount(CustomerBankAccount account) {
		this.account = account;
	}

	public long getBaccountNo() {
		return baccountNo;
	}

	public void setBaccountNo(long baccountNo) {
		this.baccountNo = baccountNo;
	}

	public BigDecimal getbAmount() {
		return bAmount;
	}

	public void setbAmount(BigDecimal bAmount) {
		this.bAmount = bAmount;
	}

}

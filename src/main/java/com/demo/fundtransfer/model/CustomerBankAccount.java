package com.demo.fundtransfer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerBankAccount {

	public CustomerBankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long accountNo;

	@Column(nullable = false, length = 23)
	private BigDecimal openingBalance;

	@Column(nullable = false, length = 23)
	private BigDecimal totalBalance;

	@Column(nullable = false, length = 23)
	private String accountType;
	
	@Column(nullable = false)
	private String ifscCode;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "beneficiaryId")
//	Beneficiary beneficiary;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	
}

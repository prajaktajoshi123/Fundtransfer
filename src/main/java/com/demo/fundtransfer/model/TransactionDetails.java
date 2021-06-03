package com.demo.fundtransfer.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long Id;

	@Column
	@NotNull(message = "firstName should not be empty")
	private long fromAccount;

	@Column(nullable = false, length = 23)
	private long toAccount;

	@Column(nullable = false, length = 23)
	private BigDecimal transactionAmount;

	@Column(nullable = false, length = 23)
	private String remarks;

	@Column
	LocalDate transactionDate;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

}

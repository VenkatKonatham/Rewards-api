package com.example.rewardsapi.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MyTransaction extends Customers {

	private String TransactionName;

	private Double total;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;

	protected MyTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected MyTransaction(String transactionName, Double total, Date date) {
		super();
		TransactionName = transactionName;
		this.total = total;
		this.date = date;
	}

	public String getTransactionName() {
		return TransactionName;
	}

	public void setTransactionName(String transactionName) {
		TransactionName = transactionName;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MyTransaction [TransactionName=" + TransactionName + ", total=" + total + ", date=" + date + "]";
	}

}

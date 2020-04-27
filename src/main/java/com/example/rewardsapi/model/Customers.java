package com.example.rewardsapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customers {

	private ArrayList<MyTransaction> transactions;
	
	protected Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Customers(ArrayList<MyTransaction> transactions) {
		super();
		this.transactions = transactions;
	}

	public ArrayList<MyTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<MyTransaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Customers [transactions=" + transactions + "]";
	}

}

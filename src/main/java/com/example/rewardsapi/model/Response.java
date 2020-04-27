package com.example.rewardsapi.model;

import java.util.Map;

public class Response {
	    private Map<String,Double> monthlyExpenditure;
	    
	    private Double total;

	    public Map<String, Double> getMonthlyExpenditure() {
	        return monthlyExpenditure;
	    }

	    public void setMonthlyExpenditure(Map<String, Double> monthlyExpenditure) {
	        this.monthlyExpenditure = monthlyExpenditure;
	    }

	    public Double getTotal() {
	        return total;
	    }

	    public void setTotal(Double total) {
	        this.total = total;
	    }
	}



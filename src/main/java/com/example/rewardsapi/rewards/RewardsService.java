package com.example.rewardsapi.rewards;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.rewardsapi.model.Customers;
import com.example.rewardsapi.model.MyTransaction;
import com.example.rewardsapi.model.Response;

@Service
public class RewardsService {

	private long points;

	private long month;

	public Response getMember(Customers customers) {

		Map<String, Double> monthMap = customers.getTransactions().stream()
				.collect(Collectors.groupingBy(myTransaction -> {
					return getMonthStringAsKey(myTransaction);
				}, Collectors.summingDouble((myTransaction) -> {
					return myTransaction.getTotal();
				})));

		Map<String, Double> resultMap = calulatePoints(monthMap);

		Response response = new Response();
		response.setMonthlyExpenditure(resultMap);
		response.setTotal(resultMap.values().stream().reduce(0d, Double::sum));
		return response;
	}

	private String getMonthStringAsKey(MyTransaction myTransaction) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(myTransaction.getDate());
		calendar.get(Calendar.MONTH);
		return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
	}

	private Map<String, Double> calulatePoints(Map<String, Double> monthMap) {
		Map<String, Double> resultMap = new HashMap<String, Double>();
		for (Entry<String, Double> month : monthMap.entrySet()) {

			resultMap.put(month.getKey(), getPoints(month.getValue()));
		}
		return resultMap;
	}

	public Double getPoints(Double transaction) {
		Double points = 0.0;
		System.out.println(transaction.toString());
		if (transaction > 50 && transaction <= 100) {
			points += (transaction - 50) * 1; // 1 point for every dollar spent over $50
		}

		if (transaction > 100) {
			points += 50;
			points += (transaction - 100) * 2; // 2 points for every dollar spent over $100
		}
		return points;
	}

}

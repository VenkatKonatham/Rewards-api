package com.example.rewardsapi.rewards;
import com.example.rewardsapi.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rewardsapi.model.Customers;

@RestController
public class RewardsController {
	
	@Autowired
	private RewardsService  rewardsService;

	@PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> getMember(@RequestBody Customers customers) {
		
		System.out.println("*******************************************");
		
		return new ResponseEntity<Response>(rewardsService.getMember(customers), HttpStatus.OK);
	}
}

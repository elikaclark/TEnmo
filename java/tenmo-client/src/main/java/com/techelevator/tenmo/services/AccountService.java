package com.techelevator.tenmo.services;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Account;
import com.techelevator.view.ConsoleService;


public class AccountService {
	private RestTemplate restTemplate = new RestTemplate();
	private static String AuthToken = "";
	private String userURL;

	
	public AccountService(String URL) {
		this.userURL = URL + "/users";
	}
	
	public Account getUserAccount(String userToken, int userId) {
		AuthToken = userToken;
		Account userAccount = null;
		try {
			userAccount = restTemplate.exchange(userURL + "/" + userId + "/account", HttpMethod.GET, makeAuth(), Account.class).getBody();
			
		} catch(RestClientResponseException e ) { 
			
		}
		
		return userAccount;
		
	}
	
	public Account updateAccount() {

		Account account = new Account();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Account> entity = new HttpEntity<>(account, headers);
		try {
		restTemplate.put(userURL + account.getAccId() + "/account", entity);
	} catch(RestClientResponseException e ) { 
			
		}
		return account;
		
	}
	
	private HttpEntity makeAuth() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(AuthToken);
		HttpEntity entity = new HttpEntity<>(headers);
		return entity;
		
	}

}

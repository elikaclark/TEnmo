package com.techelevator.tenmo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Transfer;

public class TransferService {

	private RestTemplate restTemplate = new RestTemplate();
	private static String AuthToken = "";
	private String transferURL;
	
	public TransferService(String URL) {
		this.transferURL = URL + "/transfers";
	}
	
	public Transfer returnTransferById(String userToken, int userId) {
	
			AuthToken = userToken;
			Transfer userTransfer = null;
			try {
				userTransfer = restTemplate.exchange(transferURL + "/" + userId, HttpMethod.GET, makeAuth(), Transfer.class).getBody();
				
			} catch(RestClientResponseException e ) { 
				
			}
			
			return userTransfer;
			
		}
		
		private HttpEntity makeAuth() {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setBearerAuth(AuthToken);
			HttpEntity entity = new HttpEntity<>(headers);
			return entity;
			
		}

		public Transfer[] getTransferHistory(String userToken, Long accountId) {
			AuthToken = userToken;
			Transfer[] userTransfer = null;
			try {
				userTransfer = restTemplate.exchange(transferURL + "/" + accountId, HttpMethod.GET, makeAuth(), Transfer[].class).getBody();
				
			} catch(RestClientResponseException e ) { 
				
			}
			
			return userTransfer;
			
		}
}

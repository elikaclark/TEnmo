package com.techelevator.tenmo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.User;

public class UserService {
	private RestTemplate restTemplate = new RestTemplate();
	private static String AuthToken = "";
	private String userURL;

	public UserService(String URL) {
		this.userURL = URL + "/users";
	}

	public User[] getAllUsers( int userId) {
      //AuthToken = userToken;
		User[] users = null;
		try {
			users = restTemplate.exchange(userURL, HttpMethod.GET, makeAuth(), User[].class).getBody();

		} catch (RestClientResponseException e) {

		}

		return users;

	}

	private HttpEntity makeAuth() {

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(AuthToken);
		HttpEntity entity = new HttpEntity<>(headers);
		return entity;

	}

}

package com.techelevator.tenmo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.User;

@RestController
public class TenmoAppController {

	private UserDAO userDAO;

	public TenmoAppController(UserDAO userDAO) {
		this.userDAO = userDAO;

	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> list() {

		List<User> allUsers = userDAO.findAll();
		return allUsers;
	}

	@RequestMapping(path = "/users/username", method = RequestMethod.GET)
	public User returnUserByUsername(@PathVariable String username) {

		User user = userDAO.findByUsername(username);
		return user;

	}

	@RequestMapping(path = "/users/username/{username}", method = RequestMethod.GET)
	public int returnUsernameById(@PathVariable String username) {

		int user = userDAO.findIdByUsername(username);
		return user;

	}

	@RequestMapping(path = "/addUser", method = RequestMethod.POST)
	public void addUser(@Valid @RequestBody String username, String password) {

		userDAO.create(username, password);
	}

}

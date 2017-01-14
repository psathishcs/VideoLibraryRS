package org.video.library.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.video.library.entitys.Users;
import org.video.library.repositorys.UsersRepository;

@RestController
public class UserController {
	private static final Log LOGGER = LogFactory.getLog(UserController.class);
	@Autowired
	private UsersRepository usersRepository;
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> getUsers() {
		List<Users> users = new ArrayList<>();
		usersRepository.findAll().forEach(e -> users.add(e));
		return users;
	}
	
	@RequestMapping(value="/users/{userID}", method=RequestMethod.GET)
	@ResponseBody
	public Users getUserByID(@PathVariable UUID userID){
		LOGGER.info("UUID UserID : " + userID);
		Users users = usersRepository.findByID(userID);
		return users;
	}
	
	@RequestMapping(value="/users/email/{email}", method=RequestMethod.GET)
	@ResponseBody
	public Users getUserByEmail(@PathVariable String email){
		Users users = usersRepository.findByEmail(email);
		return users;
	}

}

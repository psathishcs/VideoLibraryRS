package org.video.library.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.video.library.entitys.UserVideos;
import org.video.library.repositorys.UserVideosRepository;

@RestController
public class UserVideosController {
	
	@Autowired
	private UserVideosRepository userVideosRepository;
	
	@RequestMapping(value="/uservideos", method = RequestMethod.GET)
	@ResponseBody
	public List<UserVideos> geUserVideos() {
		List<UserVideos> userVideos = new ArrayList<>();
		userVideosRepository.findAll().forEach(e -> userVideos.add(e));
		return userVideos;
	}
	
	@RequestMapping(value="/uservideos/id", method = RequestMethod.GET)
	@ResponseBody
	public UserVideos getLatestVideosByID(@RequestParam(value="userid", defaultValue="522b1fe2-2e36-4cef-a667-cd4237d08b89")UUID userID, @RequestParam(value="addedDate", defaultValue="2013-05-02 17:30:29+0000")String addedDate,
			@RequestParam(value="videoid", defaultValue= "0c3f7e87-f6b6-41d2-9668-2b64d117102c")UUID videoID){
		return userVideosRepository.getByID(userID, addedDate, videoID);
	}

}

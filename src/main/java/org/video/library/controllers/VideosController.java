package org.video.library.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.video.library.entitys.Videos;
import org.video.library.repositorys.VideosRepository;

@RestController
public class VideosController {
	
	@Autowired
	private VideosRepository repository;
	
	@RequestMapping(value="/videos", method = RequestMethod.GET)
	@ResponseBody
	public List<Videos> getAllVidoes() {
		List<Videos> videos = new ArrayList<>();
		repository.findAll().forEach(e -> videos.add(e));
		return videos;
	}
	
	@RequestMapping(value="/videos/{videoID}", method = RequestMethod.GET)
	@ResponseBody
	public Videos getVidoeByID(@PathVariable UUID videoID) {
		Videos video =  repository.findByID(videoID);
		return video;
	}

	@RequestMapping(value="/videos/name/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Videos getVidoeByName(@PathVariable String name) {
		Videos video =  repository.findByname(name);
		return video;
	}
	

}

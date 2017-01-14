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
import org.video.library.entitys.LatestVideos;
import org.video.library.repositorys.LatestVideosRepository;

@RestController
public class LatestVideosController {
	@Autowired
	private LatestVideosRepository latestVideosRepository;
	
	
	@RequestMapping(value="/latestvideos", method = RequestMethod.GET)
	@ResponseBody
	public List<LatestVideos> getLatestVideos() {
		List<LatestVideos> latestVideos = new ArrayList<>();
		latestVideosRepository.findAll().forEach(e -> latestVideos.add(e));
		return latestVideos;
	}
	
	@RequestMapping(value="/latestvideos/id", method = RequestMethod.GET)
	@ResponseBody
	public LatestVideos getLatestVideosByID(@RequestParam(value="addedDate", defaultValue="2013-06-11 16:00:00+0000")String addedDate,
			@RequestParam(value="videoid", defaultValue= "49f64d40-7d89-4890-b910-dbf923563a33")UUID videoID,
			@RequestParam(value="yyyymmdd", defaultValue="2013-06-11")String yyyymmdd){
		return latestVideosRepository.getByID(addedDate, videoID, yyyymmdd);
	}
}

package org.video.library.entitys;

import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * 
 * @author Sathish
 * Counter table
 *	CREATE TABLE video_rating (
 *  	videoid uuid,
 *  	rating_counter counter,
 *  	rating_total counter,
 *  	PRIMARY KEY (videoid)
 *	);
 *
 */

@Table(value="video_rating")
public class VideoRating {
	@PrimaryKeyColumn(name="videoid", ordinal =0, type=PrimaryKeyType.PARTITIONED)
	private UUID videoID;
	@Column(value="rating_counter")
	private int ratingCounter;
	@Column(value="rating_total")
	private int ratingTotal;
	
	public UUID getVideoID() {
		return videoID;
	}
	public void setVideoID(UUID videoID) {
		this.videoID = videoID;
	}
	public int getRatingCounter() {
		return ratingCounter;
	}
	public void setRatingCounter(int ratingCounter) {
		this.ratingCounter = ratingCounter;
	}
	public int getRatingTotal() {
		return ratingTotal;
	}
	public void setRatingTotal(int ratingTotal) {
		this.ratingTotal = ratingTotal;
	}
}

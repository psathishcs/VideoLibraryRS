package org.video.library.entitys;

import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * 
 * @author Sathish
 * 
 *  Video ratings by user (to try and mitigate voting multiple times)
 *		CREATE TABLE video_ratings_by_user (
 *  		videoid uuid,
 *  		userid uuid,
 *  		rating int,
 *  		PRIMARY KEY (videoid, userid)
 *		);
 *
 */
@Table(value="video_ratings_by_user")
public class VideoRatingsByUser {
	@PrimaryKeyColumn(name="userid", ordinal =1, type = PrimaryKeyType.CLUSTERED)
	private UUID userID;
	@PrimaryKeyColumn(name="videoid", ordinal =0, type = PrimaryKeyType.PARTITIONED)
	private UUID videoID;
	@Column(value="rating")
	private int rating;
	
	public UUID getUserID() {
		return userID;
	}
	public void setUserID(UUID userID) {
		this.userID = userID;
	}
	public UUID getVideoID() {
		return videoID;
	}
	public void setVideoID(UUID videoID) {
		this.videoID = videoID;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}

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
 *  One-to-many from the user point of view
 *  Also know as a lookup table
 * 		CREATE TABLE user_videos (
 *  		userid uuid,
 *			added_date timestamp,
 *  		videoid uuid,
 *  		name text,
 *  		preview_image_location text,
 *  		PRIMARY KEY (userid, added_date, videoid)
 *		) WITH CLUSTERING ORDER BY (added_date DESC, videoid ASC);
 */

@Table(value="user_videos")
public class UserVideos {
	@PrimaryKeyColumn(name="userid", ordinal =1, type = PrimaryKeyType.CLUSTERED)
	private UUID userID;
	@PrimaryKeyColumn(name="added_date", ordinal =0, ordering = Ordering.DESCENDING,  type = PrimaryKeyType.PARTITIONED)
	private Date addedDate;
	@PrimaryKeyColumn(name="videoid", ordinal =0, ordering = Ordering.ASCENDING, type = PrimaryKeyType.PARTITIONED)
	private UUID videoID;
	@Column(value="name")
	private String name;
	@Column(value="preview_image_location")
	private String previewImageLocation;
	public UUID getUserID() {
		return userID;
	}
	public void setUserID(UUID userID) {
		this.userID = userID;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public UUID getVideoID() {
		return videoID;
	}
	public void setVideoID(UUID videoID) {
		this.videoID = videoID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreviewImageLocation() {
		return previewImageLocation;
	}
	public void setPreviewImageLocation(String previewImageLocation) {
		this.previewImageLocation = previewImageLocation;
	}
}

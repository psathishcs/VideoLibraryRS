package org.video.library.entitys;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
/**
 * 
 * @author Sathish
 *  Entity table that will store many videos for a unique user
 *  Meta data - Height, Width, Bit rate, Encoding
 *  Map thumbnails - stop, url
 * Selected thumbnail
 * 	CREATE TABLE videos (
 *	  	videoid uuid,
 *  	userid uuid,
 *  	name varchar,
 *  	description varchar,
 *  	location text,
 *  	location_type int,
 * 		preview_thumbnails map<text,text>,  // <position in video, url of thumbnail>
 *  	tags set<varchar>,
 *  	added_date timestamp,
 *  	PRIMARY KEY (videoid)
 *	);

 */
@Table(value="videos")
public class Videos {
	@PrimaryKeyColumn(name="videoid", ordinal =1, type=PrimaryKeyType.PARTITIONED)
	private UUID videoID;
	@Column(value="uuid")
	private UUID userID;
	@Column(value="name")
	private String name;
	@Column(value="description")
	private String description;
	@Column(value="location")
	private String location;
	@Column(value="location_type")
	private String location_type;
	@Column(value="preview_thumbnails")
	private Map<String, String> previewThumbnails;
	@Column(value="tags")
	private Set<String> tags;
	@Column(value="added_date")
	private Date addedDate;
	public UUID getVideoID() {
		return videoID;
	}
	public void setVideoID(UUID videoID) {
		this.videoID = videoID;
	}
	public UUID getUserID() {
		return userID;
	}
	public void setUserID(UUID userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public Map<String, String> getPreviewThumbnails() {
		return previewThumbnails;
	}
	public void setPreviewThumbnails(Map<String, String> previewThumbnails) {
		this.previewThumbnails = previewThumbnails;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
}

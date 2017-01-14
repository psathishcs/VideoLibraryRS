package org.video.library.entitys;

import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * 
 * @author Sathish
 *
 * Index for tag keywords
 *		CREATE TABLE videos_by_tag (
 * 			tag text,
 *  		videoid uuid,
 *  		added_date timestamp,
 *  		name text,
 *  		preview_image_location text,
 *  		tagged_date timestamp,
 *  		PRIMARY KEY (tag, videoid)
 *		);
 *
 */

@Table(value="videos_by_tag")
public class VideosByTag {
	@PrimaryKeyColumn(name="tag", ordinal =1, type = PrimaryKeyType.PARTITIONED)
	private String tag;
	@PrimaryKeyColumn(name="videoid", ordinal =1, type = PrimaryKeyType.PARTITIONED)
	private UUID videoID;
	@Column(value="added_date")
	private Date addedDate;
	@Column(value="name")
	private String name;
	@Column(value="preview_image_location")
	private String previewImageLocatation;
	@Column(value="tagged_date")
	private Date taggedDate;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public UUID getVideoID() {
		return videoID;
	}
	public void setVideoID(UUID videoID) {
		this.videoID = videoID;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreviewImageLocatation() {
		return previewImageLocatation;
	}
	public void setPreviewImageLocatation(String previewImageLocatation) {
		this.previewImageLocatation = previewImageLocatation;
	}
	public Date getTaggedDate() {
		return taggedDate;
	}
	public void setTaggedDate(Date taggedDate) {
		this.taggedDate = taggedDate;
	}
}

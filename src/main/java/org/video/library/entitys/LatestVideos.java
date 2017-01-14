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
 *  Track latest videos, grouped by day (if we ever develop a bad hotspot from the daily grouping here, we could mitigate by
 *  splitting the row using an arbitrary group number, making the partition key (yyyymmdd, group_number))
 *  	CREATE TABLE latest_videos (
 *  		yyyymmdd text,
 *  		added_date timestamp,
 *  		videoid uuid,
 * 			name text,
   preview_image_location text,
   PRIMARY KEY (yyyymmdd, added_date, videoid)
) WITH CLUSTERING ORDER BY (added_date DESC, videoid ASC);
 */
@Table(value="latest_videos")
public class LatestVideos {
	@PrimaryKeyColumn(name="yyyymmdd", ordinal =1, type = PrimaryKeyType.CLUSTERED)
	private String yyyymmdd;
	@PrimaryKeyColumn(name="added_date", ordinal =1, ordering=Ordering.DESCENDING, type = PrimaryKeyType.PARTITIONED)
	private Date addedDate;
	@PrimaryKeyColumn(name="videoid", ordinal =1, ordering=Ordering.ASCENDING, type = PrimaryKeyType.PARTITIONED)
	private UUID videoID;
	@Column(value="name")
	private String name;
	@Column(value="preview_image_location")
	private String previewImageLocation;
	public String getYyyymmdd() {
		return yyyymmdd;
	}
	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
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

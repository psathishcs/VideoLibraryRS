package org.video.library.entitys;

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
 * Comments as a many-to-many
 * Looking from the video side to many users
 *		CREATE TABLE comments_by_video (
 *  		videoid uuid,
 *  		commentid timeuuid,
 *  		userid uuid,
 *  		comment text,
 *  		PRIMARY KEY (videoid, commentid)
 *		) WITH CLUSTERING ORDER BY (commentid DESC);
 *
 */

@Table(value="comments_by_video")
public class CommentsByVideo {
	@PrimaryKeyColumn(name="videoid", ordinal=1, type=PrimaryKeyType.CLUSTERED)
	private UUID videoID;
	@PrimaryKeyColumn(name="commentid", ordinal=1, ordering=Ordering.DESCENDING,type=PrimaryKeyType.PARTITIONED)
	private UUID commentID;
	@Column(value="userid")
	private UUID userID;
	@Column(value="comment")
	private String comment;
	public UUID getVideoID() {
		return videoID;
	}
	public void setVideoID(UUID videoID) {
		this.videoID = videoID;
	}
	public UUID getCommentID() {
		return commentID;
	}
	public void setCommentID(UUID commentID) {
		this.commentID = commentID;
	}
	public UUID getUserID() {
		return userID;
	}
	public void setUserID(UUID userID) {
		this.userID = userID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
}

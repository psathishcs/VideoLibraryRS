package org.video.library.entitys;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="video_event")
public class VideoEvent {
	@PrimaryKeyColumn(name="videoid", ordinal =1, type=PrimaryKeyType.CLUSTERED)
	private UUID videoID;
	@PrimaryKeyColumn(name="userid", ordinal =1, type=PrimaryKeyType.CLUSTERED)
	private UUID userID;
	@PrimaryKeyColumn(name="event", ordinal =1, ordering=Ordering.ASCENDING,type=PrimaryKeyType.PARTITIONED)
	private String event;
	@PrimaryKeyColumn(name="event_timestamp", ordinal =1,ordering=Ordering.DESCENDING ,type=PrimaryKeyType.PARTITIONED)
	private UUID eventTimeStamp;
	@Column(value="video_timestamp")
	private BigInteger videoTimeStamp;
}

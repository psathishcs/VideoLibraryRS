package org.video.library.repositorys;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import org.video.library.entitys.LatestVideos;

@Repository
public interface LatestVideosRepository extends CassandraRepository<LatestVideos>{
	
	@Query("SELECT * FROM latest_videos WHERE added_date = ?0 and videoid = ?1 and yyyymmdd = ?2;")
	public LatestVideos getByID(String addedDate, UUID videoID, String yyyymmdd);

	@Query("SELECT * FROM latest_videos WHERE added_date = ?0 ALLOW FILTERING;")
	public List<LatestVideos> getByaddedDate(String addedDate);
	
	@Query("SELECT * FROM latest_videos WHERE videoid = ?0 ALLOW FILTERING;")
	public List<LatestVideos> getByVideoID(UUID videoID);
	
	@Query("SELECT * FROM latest_videos WHERE yyyymmdd = ?0 ALLOW FILTERING;")
	public List<LatestVideos> getByyyyymmdd(String yyyymmdd);

}

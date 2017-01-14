package org.video.library.repositorys;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import org.video.library.entitys.UserVideos;

@Repository
public interface UserVideosRepository  extends CassandraRepository<UserVideos>{
	
	@Query("SELECT * FROM user_videos WHERE  userid = ?0 and added_date = ?1 and videoid = ?2;")
	public UserVideos getByID(UUID userID, String addedDate, UUID videoID);

}

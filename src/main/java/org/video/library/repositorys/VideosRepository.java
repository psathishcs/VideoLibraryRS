package org.video.library.repositorys;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.video.library.entitys.Videos;
public interface VideosRepository extends CassandraRepository<Videos>{
	@Query("SELECT * FROM videos WHERE videoid=?0")
	public Videos findByID(UUID videoID);
	
	@Query("SELECT * FROM videos WHERE name=?0")
	public Videos findByname(String name);
}

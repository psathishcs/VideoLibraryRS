package org.video.library.repositorys;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import org.video.library.entitys.Users;

@Repository
public interface UsersRepository extends CassandraRepository<Users>{
	@Query("SELECT * FROM users where userid=?0")
	public Users findByID(UUID userID);
	
	@Query("SELECT * FROM users where email=?0")
	public Users findByEmail(String email);

}

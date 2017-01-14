package org.video.library.entitys;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
import java.util.UUID;

/**
 * 
 * @author Sathish
 * 
 *  User credentials, keyed by email address so we can authenticate
 * Seperated from user in case auth is external (Google, Facebook, etc...)
 * 	CREATE TABLE user_credentials (
 *  	email text,
 * 		password text,
 *  	userid uuid,
 *  	PRIMARY KEY (email)
 *	);
 *
 */
@Table("user_credentials")
public class UserCredentials {
	
	@PrimaryKeyColumn(name = "email",ordinal = 1,type=PrimaryKeyType.PARTITIONED)
	private String email;
	
	@Column(value="uuid")
	private UUID uuid;
	
	@Column(value="password")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

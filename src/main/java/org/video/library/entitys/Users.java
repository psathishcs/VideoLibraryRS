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
 * Basic entity table for a user
 * UUID for userid to link to auth system
 *	CREATE TABLE users (
 * 		userid uuid,
 * 		firstname varchar,
 * 		lastname varchar,
 * 		email text,
 * 		created_date timestamp,
 * 		PRIMARY KEY (userid)
 *	);
 */

@Table(value="users")
public class Users {
	@PrimaryKeyColumn(name="userid", ordinal=1,type=PrimaryKeyType.PARTITIONED)
	private UUID userId;
	 
	@Column(value="firstname")
	private String firstName;
	
	@Column(value="lastname")
	private String lastName;
	
	@Column(value="email")
	private String email;
	
	@Column(value="created_date")
	private Date createdDate;

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}

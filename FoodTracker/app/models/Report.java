package models;

import java.util.Date;
<<<<<<< HEAD
/*
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
*/

public class Report {
	
	
=======

public class Report {
	
>>>>>>> origin/master
	private String id;
	private String user_id;
	private Date timestamp;
	
<<<<<<< HEAD
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getUserId() { return this.user_id; }
	public void setUserId(String user_id) { this.user_id = user_id; }
	
	public Date getTimestamp() { return this.timestamp; }
	public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
=======
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
>>>>>>> origin/master

}

package controllers;

import java.util.Date;

public class Report {
	
	private String id;
	private String user_id;
	private Date timestamp;
	
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getUserId() { return this.user_id; }
	public void setUserId(String user_id) { this.user_id = user_id; }
	
	public Date getTimestamp() { return this.timestamp; }
	public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

}

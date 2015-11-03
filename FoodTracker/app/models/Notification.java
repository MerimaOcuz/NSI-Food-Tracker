package models;

/*
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
*/

public class Notification {
	
	
	private String id;
	private String user_id;
	private String notification_text;
	
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getUserId() { return this.user_id; }
	public void setUserId(String user_id) { this.user_id = user_id; }
	
	public String getNotificationText() { return this.notification_text; }
	public void setNotificationText(String text) { this.notification_text = text; }

}

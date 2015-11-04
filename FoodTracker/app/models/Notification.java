package models;

public class Notification {
	
	private String id;
	private String user_id;
	private String notification_text;
	
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
	public String getNotification_text() {
		return notification_text;
	}
	public void setNotification_text(String notification_text) {
		this.notification_text = notification_text;
	}

}

package models;

import java.util.Date;


public class UserExercise {

	private String id;
	private String user_id;
	private String exercise_id;
	private Date timestamp;
	private int duration_min;
	

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
	public String getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(String exercise_id) {
		this.exercise_id = exercise_id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getDuration_min() {
		return duration_min;
	}
	public void setDuration_min(int duration_min) {
		this.duration_min = duration_min;
	}

}

package models;

import java.util.Date;
<<<<<<< HEAD
/*
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
*/

public class UserExercise {
	
	
=======

public class UserExercise {
	
>>>>>>> origin/master
	private String id;
	private String user_id;
	private String exercise_id;
	private Date timestamp;
	private int duration_min;
	
<<<<<<< HEAD
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getUserId() { return this.user_id; }
	public void setUserId(String user_id) { this.user_id = user_id; }
	
	public String getExerciseId() { return this.exercise_id; }
	public void setExerciseId(String exercise_id) { this.exercise_id = exercise_id; }
	
	public Date getTimestamp() { return this.timestamp; }
	public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
	
	public int getDurationMin() { return this.duration_min; }
	public void setDurationMin(int duration_min) { this.duration_min = duration_min; }
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
>>>>>>> origin/master

}

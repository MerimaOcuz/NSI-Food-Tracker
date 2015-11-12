package models;

import java.util.Date;
import java.util.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import javax.persistence.*;

@Entity
public class UserExercise {
	
	@Id
	@GeneratedValue
	private int id;
	private String user_id;
	private int exercise_id;
	private Date timestamp;
	private int duration_min;
	
	public UserExercise(String user_id, int exercise_id, Date timestamp, int duration_min) {
		//this.id = id;
		this.user_id = user_id;
		this.exercise_id = exercise_id;
		this.timestamp = timestamp;
		this.duration_min = duration_min;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(int exercise_id) {
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
	
	public static void insert(String user_id, int exercise_id, Date timestamp, int duration_min) {
		UserExercise u = new UserExercise(user_id, exercise_id, timestamp, duration_min);
		Ebean.save(u);
	}

}

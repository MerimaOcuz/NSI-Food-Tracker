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
	private String title;
	private Date timestamp;
	private int duration_min;	//trajanje vjezbe
	private int cal_per_min;	//kalorija po minuti za datu vjezbu
	
	public UserExercise(String user_id, int exercise_id, String title, Date timestamp, int duration_min, int cal_per_min) {
		//this.id = id;
		
		this.user_id = user_id;
		this.exercise_id = exercise_id;
		this.title = title;
		this.timestamp = timestamp;
		this.duration_min = duration_min;
		this.cal_per_min = cal_per_min;
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
		return this.exercise_id;
	}
	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getTimestamp() {
		return this.timestamp;
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
	public int getCal_per_min() {
		return this.cal_per_min;
	}
	public void setCal_per_min(int cal_per_min) {
		this.cal_per_min = cal_per_min;
	}
	
	public int getAllCalories() {
		return duration_min*cal_per_min;
	}
	
	public static void insert(String user_id, int exercise_id, String title, Date timestamp, int duration_min, int cal_per_min) {
		UserExercise u = new UserExercise(user_id, exercise_id, title, timestamp, duration_min, cal_per_min);
		Ebean.save(u);
	}

}

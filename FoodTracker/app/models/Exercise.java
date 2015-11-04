package models;
<<<<<<< HEAD
/*
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
*/

public class Exercise {
	
	
=======

public class Exercise {
	
>>>>>>> origin/master
	private String id;
	private String title;
	private String description;
	private int calories_per_minute;
	
<<<<<<< HEAD
	public String getId() { return this.id; }
	public void setId(String id) {this.id = id; }
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getDescription() { return this.description; }
	public void setDescription(String description) { this.description = description; }
	
	public int getCaloriesPerMinute() { return this.calories_per_minute; }
	public void setCaloriesPerMinute(int calories_per_minute) {this.calories_per_minute = calories_per_minute; }
	
}
=======
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCalories_per_minute() {
		return calories_per_minute;
	}
	public void setCalories_per_minute(int calories_per_minute) {
		this.calories_per_minute = calories_per_minute;
	}

}
>>>>>>> origin/master

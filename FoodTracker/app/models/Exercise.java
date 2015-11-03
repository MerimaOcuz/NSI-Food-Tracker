package models;
/*
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
*/

public class Exercise {
	
	
	private String id;
	private String title;
	private String description;
	private int calories_per_minute;
	
	public String getId() { return this.id; }
	public void setId(String id) {this.id = id; }
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getDescription() { return this.description; }
	public void setDescription(String description) { this.description = description; }
	
	public int getCaloriesPerMinute() { return this.calories_per_minute; }
	public void setCaloriesPerMinute(int calories_per_minute) {this.calories_per_minute = calories_per_minute; }
	
}
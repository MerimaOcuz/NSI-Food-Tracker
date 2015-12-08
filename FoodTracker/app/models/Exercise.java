package models;

import java.util.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import javax.persistence.*;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private int calories_per_minute;
	
	public Exercise(String title, String description, int calories_per_minute) {
		this.title = title;
		this.description = description;
		this.calories_per_minute = calories_per_minute;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	public static void insert(String title, String description, int calories_per_minute) {
        Exercise e = new Exercise(title, description, calories_per_minute);
		Ebean.save(e);
    }

}

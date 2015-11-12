package models;

import java.util.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import javax.persistence.*;

@Entity
public class Exercise {
	
	@Id
	private int id;
	private String title;
	private String description;
	private int calories_per_minute;
	
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

}

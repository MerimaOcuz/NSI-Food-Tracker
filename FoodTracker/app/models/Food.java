package models;

<<<<<<< HEAD
/*
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
*/

public class Food {
	
	
=======
public class Food {
	
>>>>>>> origin/master
	private String id;
	private String name;
	private int calories;
	
<<<<<<< HEAD
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public int getCalories() { return this.calories; }
	public void setCalories(int calories) { this.calories = calories; }

=======
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
>>>>>>> origin/master
}

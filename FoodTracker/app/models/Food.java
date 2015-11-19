package models;

import java.util.Date;
import java.util.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import javax.persistence.*;

@Entity
public class Food {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int calories;

	public Food(String name, int calories) {
      this.name = name;
      this.calories = calories;
      //i fotka
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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

	public static void insert(String name, int calories) {
        Food f = new Food(name, calories);
		Ebean.save(f);
    }
	
}

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
	private String photo;

	public Food(String name, int calories, String photo) {
      this.name = name;
      this.calories = calories;
      this.photo = photo;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}

	public static void insert(String name, int calories, String photo) {
        Food f = new Food(name, calories, photo);
		Ebean.save(f);
    }
	
}

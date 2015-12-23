package models;

import java.util.Date;
import play.db.ebean.*;
import com.avaje.ebean.*;
import javax.persistence.*;

@Entity
public class FoodConsumption {
	
	@Id
	@GeneratedValue
	private int id;
	private int food_id;
	private String user_id;
	private Date timestamp;
	private String name;	//naziv hrane
	private int calories;	//kcal/g za unesenu hranu
	private int quantity;	//kolicina u gramima
	
	public FoodConsumption(String user_id, int food_id, Date timestamp, String name, int calories, int quantity) {
		this.user_id = user_id;
		this.food_id = food_id;
		this.timestamp = timestamp;
		this.name = name;
		this.calories = calories;
		this.quantity = quantity;	//kolicina u gramima
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getAllCalories() {
		return quantity*calories;
	}
	
	public static void insert(String user_id, int food_id, Date timestamp, String name, int calories, int quantity) {
		FoodConsumption u = new FoodConsumption(user_id, food_id, timestamp, name, calories, quantity);
		Ebean.save(u);
	}
}

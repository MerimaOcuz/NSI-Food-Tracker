package models;

import java.util.Date;

<<<<<<< HEAD
/*
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
*/

public class FoodConsumption {
	
	
=======
public class FoodConsumption {
	
>>>>>>> origin/master
	private String id;
	private String food_id;
	private String user_id;
	private Date timestamp;
	private int quantity;
	
<<<<<<< HEAD
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getFoodId() { return this.food_id; }
	public void setFoodId(String food_id) { this.food_id = food_id; }
	
	public String getUserId() { return this.user_id; }
	public void setUserId(String user_id) { this.user_id = user_id; }
	
	public Date getTimestamp() { return this.timestamp; }
	public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
	
	public int getQuantity() { return this.quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
=======
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFood_id() {
		return food_id;
	}
	public void setFood_id(String food_id) {
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
>>>>>>> origin/master

}

package controllers;

import java.util.Date;

public class FoodConsumption {
	
	private String id;
	private String food_id;
	private String user_id;
	private Date timestamp;
	private int quantity;
	
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

}

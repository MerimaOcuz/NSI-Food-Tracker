package models;


import java.util.Date;
import java.util.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import javax.persistence.*;


@Entity
public class User {
	@Id
	//private String id;
	private String email;
	private String password;
	private String name;
	private String surname;
	private Date birth_date;
	private String address;
	private String type;
	private String phone_number;
	private String gender;
	private String current_weight;
	private String desired_weight;
	private String height;
	
	public User(String name, String surname, Date birth_date, String email, String password, String phone, String address, String gender, String current_weight, String height, String type) {
      this.email = email;
      this.name = name;
      this.surname = surname;
      this.password = password;
      this.phone_number = phone;
      this.address = address;
	  this.birth_date = birth_date;
	  this.type = type;
	  this.gender=gender;
	  this.current_weight=current_weight;
	  this.height = height;
    }
	
	//public String getId() { return this.id; }
	//public void setId(String id) { this.id = id; }
	
	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }
	
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public String getSurname() { return this.surname; }
	public void setSurname(String surname) { this.surname = surname; }
	
	public Date getBirthDate() { return this.birth_date; }
	public void setBirthDate(Date birth_date) { this.birth_date = birth_date; }
	
	public String getAddress() { return this.address; }
	public void setAddress(String address) { this.address = address; }
	
	public String getPhoneNumber() { return this.phone_number; }
	public void setPhoneNumber(String phone_number) { this.phone_number = phone_number; }

	public String getGender() { return this.gender; }
	public void setGender(String gender) { this.gender = gender; }
	
	public String getCurrent_weight() { return this.current_weight; }
	public void setCurrent_weight(String current_weight) { this.current_weight = current_weight; }
	
	public String getDesired_weight() { return this.desired_weight; }
	public void setDesired_weight(String desired_weight) { this.desired_weight = desired_weight; }
	
	public String getHeight() { return this.height; }
	public void setHeight(String height) { this.height = height; }
	
	public String getType() { return this.type; }
	public void setType(String type) { this.type = type; }
	
	public static void insert(String name, String surname, Date birth_date, String email, String password, String phone, 
      String address, String gender, String current_weight, String height, String role) {
        User u = new User(name, surname, birth_date, email, password, phone, address, gender, current_weight, height, "User");
		Ebean.save(u);
    }
	public static User check(String email, String password) {
		        User users = Ebean.find (User.class)
		        					.where().eq("email",email).eq("password",password).findUnique();
		        return users;
		    }
	public static User getUser(String email) {
        return Ebean.find(User.class).where().eq("email", email).findUnique();
    }
}


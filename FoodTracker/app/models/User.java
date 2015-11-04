package models;

import java.util.Date;
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
	
	public User(String name, String surname, String email, String password, String phone, String address, String type) {
      this.email = email;
      this.name = name;
      this.surname = surname;
      this.password = password;
      this.phone_number = phone;
      this.address = address;
	  this.type = type;
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
	
	public String getType() { return this.type; }
	public void setType(String type) { this.type = type; }
	
	public static void insert(String name, String surname, String email, String password, String phone, 
      String address, String role) {
		  Date birth_date=new Date();
        User u = new User(name, surname, email, password, phone, address, "User");
		Ebean.save(u);
    }

}

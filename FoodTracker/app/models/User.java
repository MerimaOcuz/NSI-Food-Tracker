package models;

import java.util.Date;
/*
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
*/

public class User {
	
	
	private String id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private Date birth_date;
	private String address;
	private String phone_number;
	private String type;
	
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getUsername() { return this.username; }
	public void setUsername(String username) { this.username = username; }
	
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

}

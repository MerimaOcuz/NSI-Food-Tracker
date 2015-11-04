package models;

<<<<<<< HEAD
/*
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
*/

public class ReportDetail {
	
	
=======
public class ReportDetail {
	
>>>>>>> origin/master
	private String id;
	private String report_id;
	private String title;
	private int value;
	
<<<<<<< HEAD
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getReportId() { return this.report_id; }
	public void setReportId(String report_id) { this.report_id = report_id; }
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	
	public int getValue() { return this.value; }
	public void setValue(int value) { this.value = value; }
=======
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
>>>>>>> origin/master

}

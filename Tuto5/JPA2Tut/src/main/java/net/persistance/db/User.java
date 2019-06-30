package net.persistance.db;

import javax.persistence.Temporal;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="USER")
public class User implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="LAST_NAME")
	private String name;

	@Column(name="FIRST_NAME")
	private String forename;

	@Temporal(TemporalType.DATE)
	private java.util.Date added;

	int getID(){return this.id;}
	void setID(int i){this.id=i;}

	String getName(){return this.name;}
	void setName(String n){this.name=n;}

	String getForename(){return this.forename;}
	void setForename(String f){this.forename=f;}

	Date getAdded(){return this.added;}
	void setAdded(Date d){this.added=d;}

	public User(){}

	public User(String n, String fn,Date a){
		this.name = n;
		this.forename = fn;
		this.added = a;
	}
}

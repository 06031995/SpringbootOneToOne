package com.SpringbootOneToOne.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int auth_id;
	
	private String lname;

	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	
	public int getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Author [auth_id=" + auth_id + ", lname=" + lname + "]";
	}
	
	

}
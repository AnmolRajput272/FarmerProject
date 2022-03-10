package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credentail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String email;
	String password;
	
	public Credentail(FullPersonDetails fullPersonDetails) {
		email = fullPersonDetails.getEmail();
		password = fullPersonDetails.getPassword();
	}
	
	public Credentail(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Credentail [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	public Credentail(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Credentail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

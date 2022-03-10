package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Crop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String croptype;
	String location;
	int price;
	String description;
	int quantity;
	String email;
	
	public Crop(int id, String croptype, String location, int price, String description, int quantity, String email) {
		super();
		this.id = id;
		this.croptype = croptype;
		this.location = location;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCroptype() {
		return croptype;
	}
	public void setCroptype(String croptype) {
		this.croptype = croptype;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return "Crop [id=" + id + ", croptype=" + croptype + ", location=" + location + ", price=" + price
				+ ", description=" + description + ", quantity=" + quantity + ", email=" + email + "]";
	}
	public Crop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

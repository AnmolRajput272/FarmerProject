package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonDetails {
	
	@Id
	public int id;
	public String name;
	public long phoneNumber;
	public String address;
	public String city;
	public String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "PersonDetails [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", city=" + city + ", email=" + email + "]";
	}
	public PersonDetails(int id, String name, long phoneNumber, String address, String city, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.email = email;
	}
	public PersonDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PersonDetails(FullPersonDetails fullPersonDetails) {
		this.name = fullPersonDetails.getName();
		this.phoneNumber = fullPersonDetails.getPhoneNumber();
		this.address = fullPersonDetails.getAddress();
		this.city = fullPersonDetails.getCity();
		this.email = fullPersonDetails.getEmail();
	}
	
}

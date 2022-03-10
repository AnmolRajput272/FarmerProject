package com.example.demo.Entities;

public class FullPersonDetails {
	String Name;
	long PhoneNumber;
	String Address;
	String City;
	String Password;
	String Email;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "FullPersonDetails [Name=" + Name + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", City="
				+ City + ", Password=" + Password + ", Email=" + Email + "]";
	}
	public FullPersonDetails(String name, long phoneNumber, String address, String city, String password,
			String email) {
		super();
		Name = name;
		PhoneNumber = phoneNumber;
		Address = address;
		City = city;
		Password = password;
		Email = email;
	}
	public FullPersonDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

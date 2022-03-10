package com.example.demo.Entities;

public class CropVendorDetails {
	Crop crop;
	PersonDetails personDetails;
	public Crop getCrop() {
		return crop;
	}
	public void setCrop(Crop crop) {
		this.crop = crop;
	}
	public PersonDetails getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(PersonDetails personDetails) {
		this.personDetails = personDetails;
	}
	
	@Override
	public String toString() {
		return "CropVendorDetails [crop=" + crop + ", personDetails=" + personDetails + "]";
	}
	public CropVendorDetails(Crop crop, PersonDetails personDetails) {
		super();
		this.crop = crop;
		this.personDetails = personDetails;
	}
	public CropVendorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

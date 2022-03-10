package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MSP {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String croptype;
	int msp;
	
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
	public int getMsp() {
		return msp;
	}
	public void setMsp(int msp) {
		this.msp = msp;
	}
	@Override
	public String toString() {
		return "MSP [id=" + id + ", croptype=" + croptype + ", msp=" + msp + "]";
	}
	public MSP(int id, String croptype, int msp) {
		super();
		this.id = id;
		this.croptype = croptype;
		this.msp = msp;
	}
	public MSP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

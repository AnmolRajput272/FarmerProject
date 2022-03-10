package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Crop;

public interface CropDao extends JpaRepository<Crop,Integer>{
	
	public List<Crop> findAllByCroptypeAndLocation(String croptype, String location);
	public void deleteAllByEmail(String email);
	public List<Crop> getAllByEmail(String email);
}

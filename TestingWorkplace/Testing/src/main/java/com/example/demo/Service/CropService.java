package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.CropDao;
import com.example.demo.Entities.Crop;

@Service
public class CropService {
	
	@Autowired
	private CropDao cropDao;
	
	public List<Crop> findByCroptypeAndLocation(String croptype, String location){
		return cropDao.findAllByCroptypeAndLocation(croptype, location);
	}
	
	public Crop insertCrop(Crop crop) {
		return cropDao.save(crop);
	}
	
	public List<Crop> insertCrops(List<Crop> crops){
		ArrayList<Crop> array = new ArrayList<Crop>(); 
		for(Crop crop:crops) {
			array.add(insertCrop(crop));
		}
		return array;
	}
	
	public void deleteCrop(String email) {
		cropDao.deleteAllByEmail(email);
	}
	
	public void deleteCrops() {
		cropDao.deleteAll();
	}
	
	public List<Crop> getCropsFromEmail(String email) {
		return cropDao.getAllByEmail(email);
	}
	
	public List<Crop> getAllCrops() {
		return cropDao.findAll();
	}
}

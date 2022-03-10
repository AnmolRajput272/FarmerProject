package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.MSPDao;
import com.example.demo.Entities.MSP;

@Service
public class MSPService {
	
	@Autowired
	private MSPDao mSPDao;
	
	public int getMSP(String CropType) {
		return mSPDao.findByCroptype(CropType).getMsp();
	}
	
	public List<MSP> getAll(){
		return mSPDao.findAll();
	}
	
	public void removeAll() {
		mSPDao.deleteAll();
	}
	
	public MSP insertMSP(MSP mSP) {
		return mSPDao.save(mSP);
	}
	
	public List<MSP> insertAll(List<MSP> msps){
		ArrayList<MSP> array = new ArrayList<MSP>(); 
		for(MSP mSP:msps) {
			array.add(mSP);
		}
		return array;
	}
}

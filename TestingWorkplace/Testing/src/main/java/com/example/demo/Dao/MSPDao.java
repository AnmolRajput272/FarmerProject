package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.MSP;

public interface MSPDao extends JpaRepository<MSP,Integer>{
	
	public MSP findByCroptype(String croptype);
}

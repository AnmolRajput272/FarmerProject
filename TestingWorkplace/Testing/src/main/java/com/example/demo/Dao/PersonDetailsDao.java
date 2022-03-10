package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.PersonDetails;

public interface PersonDetailsDao extends JpaRepository<PersonDetails,Integer>{
	
	public PersonDetails findByEmail(String Email);
	public boolean existsByEmail(String Email);
}

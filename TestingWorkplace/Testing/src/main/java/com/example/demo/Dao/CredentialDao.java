package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Credentail;

public interface CredentialDao extends JpaRepository<Credentail,Integer>{
	
	public boolean existsByEmail(String email);
	public boolean existsByEmailAndPassword(String email, String password);
	public Credentail findByEmailAndPassword(String email,String password);
	public Credentail findByEmail(String email);
	public void deleteByEmail(String email);
	
}

package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.PersonDetailsDao;
import com.example.demo.Entities.PersonDetails;

@Service
public class PersonDetailsService {
	
	@Autowired
	private PersonDetailsDao personDetailsDao;
	
	public PersonDetails getOne(String email) {
		return personDetailsDao.findByEmail(email);
	}
	public List<PersonDetails> getAll() {
		return personDetailsDao.findAll();
	}
	
	public PersonDetails InsertOne(PersonDetails PersonDetail) {
		return personDetailsDao.save(PersonDetail);
	}
	public List<PersonDetails> InsertAll(List<PersonDetails> personDetails) {
		ArrayList<PersonDetails> array = new ArrayList<PersonDetails>(); 
		for(PersonDetails personDetail : personDetails) {
			array.add(InsertOne(personDetail));
		}
		return array;
	}
	
	public void DeleteOne(String email) {
		PersonDetails p = getOne(email);
		personDetailsDao.deleteById(p.getId());
	}
	public void DeleteAll() {
		personDetailsDao.deleteAll();
	}
	
	public boolean IsPersonThere(String email) {
		return personDetailsDao.existsByEmail(email);
	}
}

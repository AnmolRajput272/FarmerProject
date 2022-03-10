package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.CredentialDao;
import com.example.demo.Entities.Credentail;

@Service
public class CredentialService {
	
	@Autowired
	private CredentialDao credentialDao;
	
	public boolean validate(String email, String password) {
		return credentialDao.existsByEmailAndPassword(email, password);
	}
	
	public boolean isEmailPresent(String email) {
		return credentialDao.existsByEmail(email);
	}
	
	public Credentail AddCredential(Credentail credential) {
		return credentialDao.save(credential);
	}
	
	public Credentail getCredential(String email) {
		return credentialDao.findByEmail(email);
	}
	
	public void DeleteCredential(String email) {
		if(isEmailPresent(email)) {
			DeleteById(credentialDao.findByEmail(email).getId());
		}
	}
	
	private void DeleteById(int id) {
		credentialDao.deleteById(id);
	}
	
	public Credentail changePassword(Credentail credential) {
		return credentialDao.save(credential);
	}
	
	public List<Credentail> showCredentials(){
		return credentialDao.findAll();
	}
	
	public void removeall() {
		credentialDao.deleteAll();
	}
}

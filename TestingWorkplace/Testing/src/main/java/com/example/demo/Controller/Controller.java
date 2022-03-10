package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Credentail;
import com.example.demo.Entities.Crop;
import com.example.demo.Entities.CropVendorDetails;
import com.example.demo.Entities.FullPersonDetails;
import com.example.demo.Entities.MSP;
import com.example.demo.Entities.PersonDetails;
import com.example.demo.Service.CredentialService;
import com.example.demo.Service.CropService;
import com.example.demo.Service.MSPService;
import com.example.demo.Service.PersonDetailsService;

@RestController
public class Controller {
	
	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private MSPService mSPService;
	
	@Autowired
	private PersonDetailsService personDetailsService;
	
	@Autowired
	private CropService cropService;
	
	@GetMapping("/Hello")
	public String Hello() {
		return "Hello";
	}
	
	@GetMapping("/Credential/validate")
	public String validate(@RequestParam(value="email") String email,
		@RequestParam(value="password") String password){
		if(credentialService.validate(email, password)) {
			return "User Present";
//			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return "User Not Present";
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/Credential/Add")
	public Credentail addCredential(@RequestBody Credentail credentail) {
		return credentialService.AddCredential(credentail);
	}
	
	@DeleteMapping("/Credential/Delete")
	public String deleteCredential(@RequestBody Credentail credentail) {
		if(credentialService.validate(credentail.getEmail(), 
									  credentail.getPassword())) {
			credentialService.DeleteCredential(credentail.getEmail());
			return "User Deleted";
		}
		return "User Not Found";
	}
	
	@DeleteMapping("/Credential/DeleteUser")
	public void deleteCredential(@RequestParam(value="email") String email) {
		credentialService.DeleteCredential(email);
	}
	
	@GetMapping("/Credential/ShowAllCredentials")
	public List<Credentail> showAllCredentials(){
		return credentialService.showCredentials();
	}
	
	@PostMapping("/Credential/UpdatePassword")
	public String updatePassword(@RequestBody Credentail credential) {
		if(credentialService.isEmailPresent(credential.getEmail())) {
			Credentail c = 
					credentialService.getCredential(credential.getEmail());
			c.setPassword(credential.getPassword());
			credentialService.AddCredential(c);
			return "Password Updated";
		}
		return "User Not Found";
	}
	
	@DeleteMapping("/Credential/removeAll")
	public void removeAll() {
		credentialService.removeall();
	}
	
	@GetMapping("/MSP")
	public int getMSP(@RequestParam(value="croptype") String CropType) {
		return mSPService.getMSP(CropType);
	}
	
	@GetMapping("/MSP/GetAll")
	public List<MSP> getAll(){
		return mSPService.getAll();
	}
	
	@DeleteMapping("/MSP/removeAll")
	public void removeAllMSP() {
		mSPService.removeAll();
	}
	
	@PostMapping("/MSP/Add")
	public MSP insertMSP(@RequestBody MSP mSP) {
		return mSPService.insertMSP(mSP);
	}
	
	@PostMapping("/MSP/AddAll")
	public List<MSP> insertAll(@RequestBody List<MSP> msps){
		return mSPService.insertAll(msps);
	}
	
	
	@GetMapping("/IsPersonThere")
	public boolean IsPersonThere(@RequestParam(value="email") String email) {
		return personDetailsService.IsPersonThere(email);
	}
	
	@GetMapping("/PersonDetail")
	public PersonDetails getOnePersonDetail(@RequestParam(value="email") String email) {
		return personDetailsService.getOne(email);
	}
	@GetMapping("/PersonDetails")
	public List<PersonDetails> getAllPersonDetails() {
		return personDetailsService.getAll();
	}
	
	@PostMapping("/PersonDetail")
	public PersonDetails InsertOnePersonDetail(@RequestBody PersonDetails PersonDetail) {
		return personDetailsService.InsertOne(PersonDetail);
	}
	@PostMapping("/PersonDetails")
	public List<PersonDetails> InsertAllPersonDetails(@RequestBody List<PersonDetails> personDetails) {
		return personDetailsService.InsertAll(personDetails);
	}
	
	@DeleteMapping("/PersonDetail")
	public void DeleteOnePersonDetail(@RequestParam(value="email") String email) {
		personDetailsService.DeleteOne(email);
	}
	@DeleteMapping("/PersonDetails")
	public void DeleteAllPersonDetails() {
		personDetailsService.DeleteAll();
	}
	
	@PostMapping("/FullPersonDetail")
	public Credentail InsertfullPersonDetail
		(@RequestBody FullPersonDetails fullPersonDetails) {
		if(IsPersonThere(fullPersonDetails.getEmail())) {
			return null;
		}
		Credentail c = addCredential(new Credentail(fullPersonDetails));
		PersonDetails p = new PersonDetails(fullPersonDetails);
		p.setId(c.getId());
		InsertOnePersonDetail(p);
		return c;
	}
	
	@PostMapping("/FullPersonDetails")
	public ArrayList<Credentail> InsertfullPersonDetails(@RequestBody List<FullPersonDetails> fullPersonDetails) {
		ArrayList<Credentail> array = new ArrayList<Credentail>(); 
		for(FullPersonDetails fullPersonDetail: fullPersonDetails) {
			array.add(InsertfullPersonDetail(fullPersonDetail));
		}
		return array;
	}
	
	@GetMapping("/getCrops")
	public List<Crop> findByCroptypeAndLocation
	(@RequestParam(value="croptype") String croptype,
	 @RequestParam(value="location") String location){
		return cropService.findByCroptypeAndLocation(croptype, location);
	}
	
	@GetMapping("/getCropsWithVendorDetails")
	public List<CropVendorDetails> findByCroptypeAndLocationAndVendorDetails
	(@RequestParam(value="croptype") String croptype,
	 @RequestParam(value="location") String location){
		List<Crop> crops = 
				cropService.findByCroptypeAndLocation(croptype, location);
		ArrayList<CropVendorDetails> array = new ArrayList<CropVendorDetails>();
		for(Crop crop:crops) {
			array.add(new CropVendorDetails(crop,
					getOnePersonDetail(crop.getEmail())));
		}
		return array;
	}
	
	@PostMapping("/addCrop")
	public Crop insertCrop(@RequestBody Crop crop) {
		return cropService.insertCrop(crop);
	}
	
	@PostMapping("/addCrops")
	public List<Crop> insertCrops(@RequestBody List<Crop> crops){
		return cropService.insertCrops(crops);
	}
	
	@DeleteMapping("/removeCropsOf")
	public void deleteCrop(@RequestParam(value="email") String email) {
		cropService.deleteCrop(email);
	}
	
	@DeleteMapping("/removeAllCrops")
	public void deleteCrops() {
		cropService.deleteCrops();
	}
	
	@GetMapping("/GetCropsOf")
	public List<Crop> getCropsFromVendor
		(@RequestParam(value="email") String email) {
		return cropService.getCropsFromEmail(email);
	}
	
	@GetMapping("/GetAllCrops")
	public List<Crop> getAllCrops() {
		return cropService.getAllCrops();
	}
	
}

package com.sri.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.entity.Tourist;
import com.sri.service.ITouristServiceMgmt;

@RestController
public class TouristController {

	@Autowired
	private ITouristServiceMgmt service;

	// performing insert operation
	@PostMapping("/enroll")
	public ResponseEntity<String> touristEnrollment(@RequestBody Tourist tourist) {
		try {
			String res = service.addRecord(tourist);
			return new ResponseEntity<String>(res, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem while Enrollemnt", HttpStatus.INTERNAL_SERVER_ERROR);
		} // end of Catch block
	}// end of b.logic method

	// Fetching all the tourist Details
	@GetMapping("/allTourist")
	public ResponseEntity<?> fetchTourist() {
		try {
			Set<Tourist> allDetails = service.getAllTouristDetails();
			return new ResponseEntity<Set<Tourist>>(allDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("No record Is Available", HttpStatus.INTERNAL_SERVER_ERROR);
		} // End of catch block
	}// End of b.logic method

	//Fetching specific Record
	@GetMapping("/specific/{tid}")
	public ResponseEntity<?> getSpecificTourist(@PathVariable Integer tid) {
		try {
			return new ResponseEntity<Tourist>(service.getSpecificTouristDetails(tid),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}//End of Catch Block
	}//End of B.logic Method
}

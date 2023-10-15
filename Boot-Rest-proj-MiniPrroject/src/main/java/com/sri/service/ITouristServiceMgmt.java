package com.sri.service;

import java.util.Set;

import com.sri.entity.Tourist;
import com.sri.exception.TouristNotFoundException;

public interface ITouristServiceMgmt {
	
	String addRecord(Tourist tourist) throws Exception;
	Set<Tourist> getAllTouristDetails();
	Tourist getSpecificTouristDetails(Integer tid)throws TouristNotFoundException;
}

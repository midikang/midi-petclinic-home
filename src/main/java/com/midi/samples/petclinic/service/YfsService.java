package com.midi.samples.petclinic.service;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Location;
import com.midi.samples.petclinic.model.Zone;

public interface YfsService {

	Location findLocationById(int id) throws DataAccessException;
	
//	Collection<Location> findLocationByZoneId(String zoneId) throws DataAccessException;
	
	void saveLocation(Location location) throws DataAccessException;

	Zone findZoneById(int id) throws DataAccessException;
	
	void saveZone(Zone zone) throws DataAccessException;
	
//	void enableTrackInventory(int id) throws DataAccessException;
	
//	void disableTrackInventory(int id) throws DataAccessException;
}

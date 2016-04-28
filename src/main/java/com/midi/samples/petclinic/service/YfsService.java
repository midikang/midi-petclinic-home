package com.midi.samples.petclinic.service;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Zone;

public interface YfsService {

	Zone findZoneById(int id) throws DataAccessException;
	
	void saveZone(Zone zone) throws DataAccessException;
	
//	void enableTrackInventory(int id) throws DataAccessException;
	
//	void disableTrackInventory(int id) throws DataAccessException;
}

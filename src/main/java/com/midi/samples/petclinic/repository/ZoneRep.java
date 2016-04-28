package com.midi.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Zone;

public interface ZoneRep {

	Zone findById(int id) throws DataAccessException;
	
	void save(Zone zone) throws DataAccessException;
	
//	void enableTrackInventory(int id) throws DataAccessException;
	
//	void disableTrackInventory(int id) throws DataAccessException;
}

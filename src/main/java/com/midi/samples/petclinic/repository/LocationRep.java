package com.midi.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Location;

public interface LocationRep {
	
	Location findById(int id) throws DataAccessException;
	
	Collection<Location> findByZoneId(String zoneId) throws DataAccessException;
	
	void save(Location location) throws DataAccessException;

}

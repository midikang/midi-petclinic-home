package com.midi.samples.petclinic.repository.springdatajpa;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.midi.samples.petclinic.model.Location;
import com.midi.samples.petclinic.repository.LocationRep;

public interface SDLocationRep extends LocationRep, Repository<Location, Integer>{

	@Override
	@Query("SELECT location FROM Location location WHERE location.id = :id")
	Location findById(@Param("id") int id) throws DataAccessException;

//	@Override
//	@Query("SELECT location FROM Location location WHERE location.zoneId = :zoneId")
//	Collection<Location> findByZoneId(@Param("zoneId") String zoneId) throws DataAccessException;

}

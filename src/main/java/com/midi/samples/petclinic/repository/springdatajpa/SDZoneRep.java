package com.midi.samples.petclinic.repository.springdatajpa;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.midi.samples.petclinic.model.Zone;
import com.midi.samples.petclinic.repository.ZoneRep;

public interface SDZoneRep extends ZoneRep, Repository<Zone, Integer> {

	@Override
	@Query("SELECT zone from Zone zone left join fetch zone.locations where zone.id= :id")
	Zone findById(@Param("id") int id) throws DataAccessException;

//	@Override
//	@Modifying
//	@Query("UPDATE Zone zone SET zone.trackInventory=true WHERE zone.id = :id")
//	void enableTrackInventory(@Param("id") int id) throws DataAccessException;

//	@Override
//	@Modifying
//	@Query("UPDATE Zone zone SET zone.trackInventory=false WHERE zone.id = :id")
//	void disableTrackInventory(@Param("id") int id) throws DataAccessException;

	
	
}

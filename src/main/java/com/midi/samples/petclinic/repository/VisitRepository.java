package com.midi.samples.petclinic.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Visit;

public interface VisitRepository {

	void save(Visit visit) throws DataAccessException;
	
	List<Visit> findByPetId(Integer petId) throws DataAccessException;
}

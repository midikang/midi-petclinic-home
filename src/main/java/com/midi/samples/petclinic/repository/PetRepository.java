package com.midi.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.PetType;

public interface PetRepository {

	Collection<PetType> findPetTypes() throws DataAccessException;
	
	Pet findById(int id) throws DataAccessException;
	
	void save(Pet pet) throws DataAccessException;
}

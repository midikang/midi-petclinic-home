package com.midi.samples.petclinic.repository.springdatajpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.PetType;
import com.midi.samples.petclinic.repository.PetRepository;

public interface SpringDataPetRepository extends PetRepository, Repository<Pet, Integer> {

	@Override
	@Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
	List<PetType> findPetTypes() throws DataAccessException;

}

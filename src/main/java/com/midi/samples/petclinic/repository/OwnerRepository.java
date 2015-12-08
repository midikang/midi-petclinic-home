package com.midi.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Owner;

public interface OwnerRepository {

	Owner findById(int id) throws DataAccessException;
	
	Collection<Owner> findByLastName(String lastName) throws DataAccessException;
	
	/**
	 * Save an <code>Owner</code> to the data store, either inserting or updating it.
	 * @param owner
	 * @throws DataAccessException
	 */
	void save(Owner owner) throws DataAccessException;
}

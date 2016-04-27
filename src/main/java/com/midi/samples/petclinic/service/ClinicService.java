package com.midi.samples.petclinic.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.PetType;
import com.midi.samples.petclinic.model.Shipment;
import com.midi.samples.petclinic.model.Vet;
import com.midi.samples.petclinic.model.Visit;

public interface ClinicService {
	Owner findOwnerById(int id) throws DataAccessException;
	
	Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException;
	
	/**
	 * Save an <code>Owner</code> to the data store, either inserting or updating it.
	 * @param owner
	 * @throws DataAccessException
	 */
	void saveOwner(Owner owner) throws DataAccessException;
	
	Collection<PetType> findPetTypes() throws DataAccessException;
	
	void savePet(Pet pet) throws DataAccessException;

	Pet findPetById(int petId) throws DataAccessException;
	
	
	void saveVisit(Visit visit) throws DataAccessException;
	
	List<Visit> findVisitByPetId(Integer petId) throws DataAccessException;

	Collection<Vet> findVets();
	
	Shipment findShipmentById(int id) throws DataAccessException;
	
	Collection<Shipment> findByCustomerName(String customerName) throws DataAccessException;
	
	void saveShipment(Shipment shipment) throws DataAccessException;
}

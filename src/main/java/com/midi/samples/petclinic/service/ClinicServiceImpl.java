package com.midi.samples.petclinic.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.PetType;
import com.midi.samples.petclinic.model.Visit;
import com.midi.samples.petclinic.repository.OwnerRepository;
import com.midi.samples.petclinic.repository.PetRepository;
import com.midi.samples.petclinic.repository.VisitRepository;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	private OwnerRepository ownerRepository;
	private PetRepository petRepository;
	private VisitRepository visitRepository;
	
	@Autowired
	public ClinicServiceImpl(OwnerRepository ownerRepository,PetRepository petRepository, VisitRepository visitRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.visitRepository = visitRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Owner findOwnerById(int id) throws DataAccessException {
		return ownerRepository.findById(id);
	}

	@Override
	@Transactional
	public void saveOwner(Owner owner) throws DataAccessException {
		ownerRepository.save(owner);
	}
    
    @Override
	@Transactional(readOnly=true)
	public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public Collection<PetType> findPetTypes() throws DataAccessException {
		return petRepository.findPetTypes();
	}

	@Override
	@Transactional
	public void savePet(Pet pet) throws DataAccessException {
		petRepository.save(pet);
	}

	@Override
	public Pet findPetById(int petId) throws DataAccessException {
		return petRepository.findById(petId);
	}

	@Override
	@Transactional
	public void saveVisit(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	@Override
	public List<Visit> findVisitByPetId(Integer petId) throws DataAccessException {
		return visitRepository.findByPetId(petId);
	}
	
	

/*
	@Override
	public Owner findOwnerById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOwner(Owner owner) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<PetType> findPetTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePet(Pet pet) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet findPetById(int petId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveVisit(Visit visit) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Visit> findVisitByPetId(Integer petId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}

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
import com.midi.samples.petclinic.model.Shipment;
import com.midi.samples.petclinic.model.Vet;
import com.midi.samples.petclinic.model.Visit;
import com.midi.samples.petclinic.repository.OwnerRepository;
import com.midi.samples.petclinic.repository.PetRepository;
import com.midi.samples.petclinic.repository.ShipmentRepository;
import com.midi.samples.petclinic.repository.VetRepository;
import com.midi.samples.petclinic.repository.VisitRepository;

@Service
public class ClinicServiceImpl implements ClinicService {

	private OwnerRepository ownerRepository;
	private PetRepository petRepository;
	private VisitRepository visitRepository;
	private VetRepository vetRepository;
	private ShipmentRepository shipmentRepository;
	
	@Autowired
	public ClinicServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository,
			VisitRepository visitRepository, VetRepository vetRepository, ShipmentRepository shipmentRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.visitRepository = visitRepository;
		this.vetRepository = vetRepository;
		this.shipmentRepository = shipmentRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Owner findOwnerById(int id) throws DataAccessException {
		return ownerRepository.findById(id);
	}

	@Override
	@Transactional
	public void saveOwner(Owner owner) throws DataAccessException {
		ownerRepository.save(owner);
	}

	@Override
	@Transactional(readOnly = true)
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

	@Override
	@Transactional(readOnly=true)
	// TODO cacheable
	public Collection<Vet> findVets() {
		return vetRepository.findAll();
	}

	@Override
	public Shipment findShipmentById(int id) throws DataAccessException {
		return shipmentRepository.findById(id);
	}

	@Override
	public Collection<Shipment> findByCustomerName(String customerName) throws DataAccessException {
		return shipmentRepository.findByCustomerName(customerName);
	}

	@Override
	public void saveShipment(Shipment shipment) throws DataAccessException {
		shipmentRepository.save(shipment);
	}

}

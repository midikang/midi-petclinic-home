package com.midi.samples.petclinic.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.PetType;
import com.midi.samples.petclinic.repository.PetRepository;

@Repository
public class JpaPetRepository implements PetRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PetType> findPetTypes() throws DataAccessException {
		return em.createQuery("SELECT ptype FROM PetType ptype ORDER BY ptype.name").getResultList();
	}

	@Override
	public Pet findById(int id) throws DataAccessException {
		return this.em.find(Pet.class, id);
	}

	@Override
	public void save(Pet pet) throws DataAccessException {
		if (pet.isNew()) {
			this.em.persist(pet);
		} else {
			this.em.merge(pet);
		}
		
	}

}

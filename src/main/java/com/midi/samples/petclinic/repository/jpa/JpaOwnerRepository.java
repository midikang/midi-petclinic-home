package com.midi.samples.petclinic.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.repository.OwnerRepository;

/**
 * JPA implementation of the interface
 * 
 * @author Midi Kang
 *
 */
@Repository
public class JpaOwnerRepository implements OwnerRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Owner findById(int id) throws DataAccessException {
		Query query = this.em.createQuery("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id");
		query.setParameter("id", id);
		return (Owner)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Owner> findByLastName(String lastName) throws DataAccessException {
		Query query = this.em.createQuery("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName");
//		Query query = this.em.createQuery("SELECT owner FROM Owner owner  WHERE owner.lastName LIKE :lastName");
		
		query.setParameter("lastName", lastName + "%");
		return query.getResultList();
	}

	@Override
	public void save(Owner owner) throws DataAccessException {
		if (owner.getId() == null) {
			this.em.persist(owner);
		} else {
			this.em.merge(owner);
		}
	}

}

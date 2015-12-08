package com.midi.samples.petclinic.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Visit;
import com.midi.samples.petclinic.repository.VisitRepository;

@Repository
public class JpaVisitRepository implements VisitRepository{

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	public void save(Visit visit) throws DataAccessException {
		if (visit.isNew()) {
			this.em.persist(visit);
		} else {
			this.em.merge(visit);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> findByPetId(Integer petId) throws DataAccessException {
		Query query = this.em.createQuery("SELECT visit FROM Visit v WHERE v.pets.id=:id");
		query.setParameter("id", petId);
		return query.getResultList();
	}

}

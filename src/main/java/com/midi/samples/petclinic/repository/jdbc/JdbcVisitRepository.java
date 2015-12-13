package com.midi.samples.petclinic.repository.jdbc;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Visit;
import com.midi.samples.petclinic.repository.VisitRepository;


@Repository
public class JdbcVisitRepository implements VisitRepository {

	@Override
	public void save(Visit visit) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Visit> findByPetId(Integer petId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.midi.samples.petclinic.repository.jdbc;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Vet;
import com.midi.samples.petclinic.repository.VetRepository;

@Repository
public class JdbcVetRepository implements VetRepository {

	@Override
	public Collection<Vet> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}

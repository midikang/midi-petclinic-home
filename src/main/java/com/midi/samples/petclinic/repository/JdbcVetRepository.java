package com.midi.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Vet;

public class JdbcVetRepository implements VetRepository {

	@Override
	public Collection<Vet> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}

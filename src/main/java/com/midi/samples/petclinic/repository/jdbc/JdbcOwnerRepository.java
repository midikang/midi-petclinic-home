package com.midi.samples.petclinic.repository.jdbc;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.repository.OwnerRepository;

@Repository
public class JdbcOwnerRepository implements OwnerRepository {

	@Override
	public Owner findById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Owner> findByLastName(String lastName) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Owner owner) throws DataAccessException {
		// TODO Auto-generated method stub

	}

}

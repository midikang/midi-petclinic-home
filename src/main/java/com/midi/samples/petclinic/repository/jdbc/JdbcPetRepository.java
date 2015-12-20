package com.midi.samples.petclinic.repository.jdbc;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.PetType;
import com.midi.samples.petclinic.repository.PetRepository;

@Repository
public class JdbcPetRepository implements PetRepository {

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Override
	public Collection<PetType> findPetTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet findById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pet pet) throws DataAccessException {
		// TODO Auto-generated method stub

	}

}

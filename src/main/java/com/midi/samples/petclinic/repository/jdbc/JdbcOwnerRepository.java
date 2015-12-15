package com.midi.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.repository.OwnerRepository;

@Repository
public class JdbcOwnerRepository implements OwnerRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcInsert insertOwner;
	
	@Autowired
	public JdbcOwnerRepository(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.insertOwner = new SimpleJdbcInsert(dataSource)
				.withTableName("owner")
				.usingGeneratedKeyColumns("id");
		
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Owner findById(int id) throws DataAccessException {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		String sql = "SELECT owner_id, first_name, last_name, address, city, telephone FROM owners WHERE id=:id";
		Owner owner ;
		try {
			owner = this.namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Owner.class));
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectRetrievalFailureException(Owner.class,id);
		}
		loadPetsAndVisits(owner);
		return owner;
	}

	@Override
	public Collection<Owner> findByLastName(String lastName) throws DataAccessException {
		String sql = "SELECT id, first_name, last_name, address, city, telephone FROM owners WHERE last_name=:lastName";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("lastName", lastName + "%");
		
		List<Owner> owners = this.namedParameterJdbcTemplate.query(sql, paramMap, BeanPropertyRowMapper.newInstance(Owner.class));
		loadOwnersPetsAndVisits(owners);
		return owners;
	}

	private void loadOwnersPetsAndVisits(List<Owner> owners) {
		for (Owner owner: owners) {
			loadPetsAndVisits(owner);
		}
	}

	private void loadPetsAndVisits(Owner owner) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", owner.getId());
		String sql = "SELECT pets.id, name, birth_date, type_id, owner_id, visits.id as visit_id, visit_date, description, pet_id "
				+ "FROM pets LEFT JOIN visits ON pets.id=pet_id WHERE owner_id=:id";
		List<JdbcPet> pets = this.namedParameterJdbcTemplate.query(sql, map, new JdbcPetVisitExtractor());
		for (Pet pet : pets) {
			owner.addPet(pet);
		}
	}

	@Override
	public void save(Owner owner) throws DataAccessException {
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(owner);
		if (owner.isNew()) {
			Number returnKey = this.insertOwner.executeAndReturnKey(paramMap);
			owner.setId(returnKey.intValue());
		} else {
			String sql =  "UPDATE owners SET first_name=:firstName, last_name=:lastName, address=:address, "
					+ "city=:city, telephone=:telephone WHERE id=:id";
			this.namedParameterJdbcTemplate.update(sql , paramMap);
		}
	}

}

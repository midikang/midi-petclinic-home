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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.repository.OwnerRepository;

@Repository
public class JdbcOwnerRepository implements OwnerRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private SimpleJdbcInsert simpleJdbcInsert;
	
	
	/**
	 * 
	 * Autowire 'dataSource' bean in DataSourceConfig in constructor
	 * @param dataSource
	 * @param namedParameterJdbcTemplate
	 */
	@Autowired
	public JdbcOwnerRepository(DataSource dataSource) {
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("owners")
				.usingGeneratedKeyColumns("id");
		
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Owner findById(int id) throws DataAccessException {
		Owner owner;
		String sql = "SELECT id, first_name, last_name, address, city, telephone FROM owners WHERE id=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		try {
			owner = this.namedParameterJdbcTemplate.queryForObject(sql, paramMap,
					BeanPropertyRowMapper.newInstance(Owner.class));
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectRetrievalFailureException(Owner.class,id);
		}
		
		loadPetsAndVisits(owner);
		return owner;
	}

	private void loadPetsAndVisits(Owner owner) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", owner.getId());
		String sql = "SELECT pets.id, name, birth_name, type_id, owner_id, visits.id as visit_id "
				+ "visit_date, description, pet_id "
				+ "FROM pets LEFT OUTER JOIN visits "
				+ "ON pets.id = visits.pet_id "
				+ "WHERE owner_id=:id";
		
		final List<JdbcPet> pets = this.namedParameterJdbcTemplate.query(sql, 
				params,
				new JdbcPetVisitExtractor());
		
		
	}

	@Override
	public Collection<Owner> findByLastName(String lastName) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Owner owner) throws DataAccessException {
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(owner);
		if (owner.isNew()) {
			Number newKey =
					this.simpleJdbcInsert.executeAndReturnKey(parameterSource);
			owner.setId(newKey.intValue());
		}  else {
			this.namedParameterJdbcTemplate.update("UPDATE onwers SET first_name=:first_name, "
					+ "last_name=:last_name, address=:address, city=:city, "
					+ "telephone=:telephone WHERE id=:id", 
					parameterSource);
		}
		
	}

}

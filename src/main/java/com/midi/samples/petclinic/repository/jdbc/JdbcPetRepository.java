package com.midi.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.PetType;
import com.midi.samples.petclinic.repository.PetRepository;

@Repository
public class JdbcPetRepository implements PetRepository {

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private SimpleJdbcInsert jdbcInsert;
	
	@Autowired
	public JdbcPetRepository(DataSource dataSource, NamedParameterJdbcTemplate jdbcTemplate) {
		
		this.jdbcInsert = new SimpleJdbcInsert(dataSource) 
				.withTableName("pets")
				.usingGeneratedKeyColumns("id");
		
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	@Override
	public Collection<PetType> findPetTypes() throws DataAccessException {
		Map<String,Object> paramMap = new HashMap<>();
		String sql = "SELECT id, name FROM types ORDER BY name";
		return 	this.jdbcTemplate.query(sql, paramMap, BeanPropertyRowMapper.newInstance(PetType.class));
	}

	@Override
	public Pet findById(int id) throws DataAccessException {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		String sql = "SELECT id, name, birth_date, type_id, owner_id FROM pets WHERE id=:id";
		Pet pet = this.jdbcTemplate.queryForObject(sql , paramMap, BeanPropertyRowMapper.newInstance(Pet.class));
		return pet;
	}

	@Override
	public void save(Pet pet) throws DataAccessException {
		BeanPropertySqlParameterSource para = new BeanPropertySqlParameterSource(pet);
		if (pet.isNew()) {
			// insert
			Number  returnKey=this.jdbcInsert.executeAndReturnKey(para);
			int petId = returnKey.intValue();
			pet.setId(petId);
		} else {
			String sql  ="UPDATE pets SET  name=:name, birth_date=:birthDate, type_id=:typeId, owner_id=:ownerId WHERE id=:id";
			//update
			this.jdbcTemplate.update(sql  , para);
		}
	}

}

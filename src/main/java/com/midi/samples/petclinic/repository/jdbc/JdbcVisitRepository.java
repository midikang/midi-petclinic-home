package com.midi.samples.petclinic.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.Visit;
import com.midi.samples.petclinic.repository.VisitRepository;


@Repository
public class JdbcVisitRepository implements VisitRepository {

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private SimpleJdbcInsert jdbcInsert;
	
	@Autowired
	public JdbcVisitRepository(DataSource dataSource){
		this.jdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("visits")
				.usingGeneratedKeyColumns("id");
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Visit visit) throws DataAccessException {
		BeanPropertySqlParameterSource paramap = new BeanPropertySqlParameterSource(visit);
		
		if (visit.isNew()) {
			Number newKey = this.jdbcInsert.executeAndReturnKey(paramap);
			visit.setId(newKey.intValue());
		} else {
			String sql = "UPDATE visits set pet_id=:pet_id, visit_date=:visit_date, description=:description WHERE id=:id ";
			jdbcTemplate.update(sql, paramap);
		}
	}

	@Override
	public List<Visit> findByPetId(Integer petId) throws DataAccessException {
		String sql = "SELECT id, pet_id, visit_date, description FROM visits WHERE pet_id=:pet_id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pet_id", petId);
		List<Visit> visits = this.jdbcTemplate.queryForList(sql, paramMap, Visit.class);
		return visits;
	}

}

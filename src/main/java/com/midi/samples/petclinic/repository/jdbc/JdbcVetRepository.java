package com.midi.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.model.Vet;
import com.midi.samples.petclinic.repository.VetRepository;

@Repository
public class JdbcVetRepository implements VetRepository {

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcVetRepository(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public Collection<Vet> findAll() throws DataAccessException {
		String sql = "SELECT id, first_name, last_name FROM vets";
		Map<String, Object> paramMap = new HashMap<>();
		List<Vet> vets = this.jdbcTemplate.queryForList(sql, paramMap, Vet.class);
		return vets;
	}

}

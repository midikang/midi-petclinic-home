package com.midi.samples.petclinic.repository.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

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
		 
	}

	@Override
	public List<Visit> findByPetId(Integer petId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}

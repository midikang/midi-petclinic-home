package com.midi.samples.petclinic.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.LocalDate;
import org.springframework.jdbc.core.RowMapper;

import com.midi.samples.petclinic.model.Visit;

public class JdbcVisitRowMapper implements RowMapper<Visit> {

	@Override
	public Visit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Visit visit = new Visit();
		visit.setId(rs.getInt("id"));
		visit.setDate(new LocalDate(rs.getDate("visit_date")));
		visit.setDescription(rs.getString("description"));
		return visit;
	}

}

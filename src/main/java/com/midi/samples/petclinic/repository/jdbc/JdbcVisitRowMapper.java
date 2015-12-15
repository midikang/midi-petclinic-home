package com.midi.samples.petclinic.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import com.midi.samples.petclinic.model.Visit;

public class JdbcVisitRowMapper implements RowMapper<Visit> {

	@Override
	public Visit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Visit visit = new Visit();
		visit.setId(rs.getInt("id"));
		visit.setDescription(rs.getString("description"));
		visit.setDate(new DateTime(rs.getDate("visit_date")));
		return visit;
	}

}

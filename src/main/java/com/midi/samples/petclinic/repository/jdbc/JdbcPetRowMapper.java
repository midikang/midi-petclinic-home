package com.midi.samples.petclinic.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

public class JdbcPetRowMapper implements RowMapper<JdbcPet> {

	@Override
	public JdbcPet mapRow(ResultSet rs, int rowNum) throws SQLException {
		JdbcPet pet = new JdbcPet(); 
		pet.setId(rs.getInt("pets.id"));
		pet.setName(rs.getString("name"));
		pet.setBirthDate(new DateTime( rs.getDate("birth_date")));
		pet.setTypeId(rs.getInt("type_id"));
		pet.setOwnerId(rs.getInt("owner_id"));
		return pet;
	}

}

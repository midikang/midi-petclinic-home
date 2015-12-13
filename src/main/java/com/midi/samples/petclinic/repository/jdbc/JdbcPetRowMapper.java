package com.midi.samples.petclinic.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcPetRowMapper implements RowMapper<JdbcPet> {

	@Override
	public JdbcPet mapRow(ResultSet rs, int rowNum) throws SQLException {
		JdbcPet pet = new JdbcPet();
		pet.setId(rs.getInt("pets.id"));
		pet.setName(rs.getString("name"));
		Date birthDate = rs.getDate("birth_date");
		pet.setBirthDate(new LocalDate(birthDate));
		pet.setTypeId(rs.getInt("type_id"));
		pet.setOwnerId(rs.getInt("owner_id"));
		return pet;
	}

}

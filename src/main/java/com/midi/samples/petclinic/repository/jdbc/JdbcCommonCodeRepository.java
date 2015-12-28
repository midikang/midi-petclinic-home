package com.midi.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.midi.samples.petclinic.repository.CommonCodeRepository;
import com.midi.wms.yfs.model.CommonCode;

@Repository
public class JdbcCommonCodeRepository implements CommonCodeRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcInsert insertCommonCode;

	@Autowired
	public JdbcCommonCodeRepository(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.insertCommonCode = new SimpleJdbcInsert(dataSource)
				.withTableName("commoncodes")
				.usingGeneratedKeyColumns("id");
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void save(CommonCode commonCode) throws DataAccessException {
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(commonCode);
		if (commonCode.isNew()) {
			Number returnKey = this.insertCommonCode.executeAndReturnKey(paramMap);
			commonCode.setId(returnKey.intValue());
		} else {
			String sql = "UPDATE commoncodes set ";
			this.namedParameterJdbcTemplate.update(sql , paramMap);
		}
	}

	@Override
	public Collection<CommonCode> findByCodeType(String codeType) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}

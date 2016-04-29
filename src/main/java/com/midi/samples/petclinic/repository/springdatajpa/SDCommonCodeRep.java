package com.midi.samples.petclinic.repository.springdatajpa;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.midi.samples.petclinic.model.CommonCode;
import com.midi.samples.petclinic.repository.CommonCodeRep;

public interface SDCommonCodeRep extends CommonCodeRep, Repository<CommonCode, Integer>{

	@Override
	@Query("SELECT commonCode from CommonCode commonCode WHERE commonCode.codeType = :codeType ")
	Collection<CommonCode> findByCodeType(@Param("codeType") String codeType) throws DataAccessException;

}

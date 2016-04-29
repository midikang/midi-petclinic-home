package com.midi.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.CommonCode;

public interface CommonCodeRep {

	Collection<CommonCode> findByCodeType(String codeType) throws DataAccessException;
	
	void save(CommonCode commonCode) throws DataAccessException;
}

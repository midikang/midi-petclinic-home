package com.midi.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.midi.wms.yfs.model.CommonCode;

public interface CommonCodeRepository {

	void save(CommonCode commonCode) throws DataAccessException;
	
	Collection<CommonCode> findByCodeType(String codeType) throws DataAccessException;
}

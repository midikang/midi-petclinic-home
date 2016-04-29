package com.midi.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midi.samples.petclinic.model.CommonCode;
import com.midi.samples.petclinic.model.Location;
import com.midi.samples.petclinic.model.Zone;
import com.midi.samples.petclinic.repository.CommonCodeRep;
import com.midi.samples.petclinic.repository.LocationRep;
import com.midi.samples.petclinic.repository.ZoneRep;

@Service
public class YfsServiceImpl implements YfsService {

	private CommonCodeRep commonCodeRep;
	private ZoneRep zoneRep;
	private LocationRep locationRep;
	
	@Autowired
	public YfsServiceImpl(CommonCodeRep commonCodeRep, ZoneRep zoneRep, LocationRep locationRep) {
		this.commonCodeRep = commonCodeRep;
		this.zoneRep = zoneRep;
		this.locationRep = locationRep;
	}

	@Override
	@Transactional(readOnly = true)
	public Zone findZoneById(int id) throws DataAccessException {
		return zoneRep.findById(id);
	}
	
	@Override
	@Transactional
	public void saveZone(Zone zone) throws DataAccessException {
		zoneRep.save(zone);
	}
	
//	@Override
//	@Transactional
//	public void enableTrackInventory(int id) throws DataAccessException {
//		zoneRep.enableTrackInventory(id);
//	}
//
//	@Override
//	@Transactional
//	public void disableTrackInventory(int id) throws DataAccessException {
//		zoneRep.disableTrackInventory(id);
//	}
	
	@Override
	@Transactional(readOnly=true)
	public Location findLocationById(int id) throws DataAccessException {
		return locationRep.findById(id);
	}

//	@Override
//	@Transactional(readOnly=true)
//	public Collection<Location> findLocationByZoneId(String zoneId) throws DataAccessException {
//		return locationRep.findByZoneId(zoneId);
//	}

	@Override
	@Transactional
	public void saveLocation(Location location) throws DataAccessException {
		locationRep.save(location);
	}

	@Override
	public Collection<CommonCode> findCommonCodeByCodeType(String codeType) throws DataAccessException {
		return this.commonCodeRep.findByCodeType(codeType);
	}

	@Override
	public void saveCommonCode(CommonCode commonCode) throws DataAccessException {
		this.commonCodeRep.save(commonCode);
	}


}

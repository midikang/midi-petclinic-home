package com.midi.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midi.samples.petclinic.model.Zone;
import com.midi.samples.petclinic.repository.ZoneRep;

@Service
public class YfsServiceImpl implements YfsService {

	private ZoneRep zoneRep;
	
	@Autowired
	public YfsServiceImpl(ZoneRep zoneRep) {
		this.zoneRep = zoneRep;
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

}

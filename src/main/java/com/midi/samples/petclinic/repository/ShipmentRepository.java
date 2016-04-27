package com.midi.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Shipment;

public interface ShipmentRepository {

	Shipment findById(int id) throws DataAccessException;
	
	Collection<Shipment> findByCustomerName(String customerName) throws DataAccessException;
	
	void save(Shipment shipment) throws DataAccessException;
	
}

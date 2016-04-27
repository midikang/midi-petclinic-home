package com.midi.samples.petclinic.repository.springdatajpa;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.midi.samples.petclinic.model.Shipment;
import com.midi.samples.petclinic.repository.ShipmentRepository;

public interface SpringDataShipmentRepository extends ShipmentRepository, Repository<Shipment, Integer> {

	@Override
	@Query("SELECT shipment FROM Shipment shipment WHERE shipment.id =:id")
	Shipment findById(@Param("id")int id) throws DataAccessException;

	@Override
	@Query("SELECT shipment FROM Shipment shipment WHERE shipment.customerName like :customerName%")
	Collection<Shipment> findByCustomerName(@Param("customerName")String customerName) throws DataAccessException;

	//@Override
	//void save(Shipment shipment) throws DataAccessException;

}

package com.midi.samples.petclinic.repository.springdatajpa;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.repository.OwnerRepository;

public interface SpringDataOwnerRepository extends OwnerRepository, Repository<Owner, Integer> {

	@Override
	@Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%")
	Collection<Owner> findByLastName(@Param("lastName") String lastName);

	@Override
	@Query("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id")
	Owner findById(@Param("id") int id) ;


	// no need to add save(Owner owner) ?

}

package com.midi.samples.petclinic.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.midi.samples.petclinic.model.Vet;

public interface VetRepository {
	Collection<Vet> findAll() throws DataAccessException;
}

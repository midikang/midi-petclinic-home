package com.midi.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.Repository;

import com.midi.samples.petclinic.model.Vet;
import com.midi.samples.petclinic.repository.VetRepository;

public interface SpringDataVetRepository extends VetRepository, Repository<Vet, Integer> {

}

package com.midi.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.Repository;

import com.midi.samples.petclinic.model.Visit;
import com.midi.samples.petclinic.repository.VisitRepository;

public interface SpringDataVisitRepository extends VisitRepository, Repository<Visit, Integer> {

}

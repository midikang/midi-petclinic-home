package com.midi.samples.petclinic.web;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import com.midi.samples.petclinic.model.PetType;
import com.midi.samples.petclinic.service.ClinicService;

public class PetTypeFormatter implements Formatter<PetType> {

	private final ClinicService clinicService;
	
	@Autowired
	public PetTypeFormatter(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	@Override
	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}

	@Override
	public PetType parse(String name, Locale locale) throws ParseException {
		Collection<PetType> petTypes=this.clinicService.findPetTypes();
		for (PetType petType : petTypes) {
			if (petType.getName().equals(name)) {
				return petType;
			}
		}
		throw new ParseException("pet type not found",0);
	}

}

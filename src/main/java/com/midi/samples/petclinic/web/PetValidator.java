package com.midi.samples.petclinic.web;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.midi.samples.petclinic.model.Pet;

public class PetValidator implements Validator {

	/**
	 * 
	 * This validator just validates Pet instances
	 * 
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Pet.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Pet pet = (Pet)target;
		String name = pet.getName();
		// name validation
		if (!StringUtils.hasLength(name)) {
			errors.rejectValue("name", "required", "required");
		} else if (pet.isNew() && pet.getOwner().getPet(name, true) != null) {
			errors.rejectValue("name", "duplicate", "already exists");
		}
		
		// type validation
		/*
		if (pet.isNew() && pet.getType()==null) {
			errors.rejectValue("type", "required","required");
		}*/
		
		//birth date validation
		if (pet.getBirthDate() == null) {
			errors.rejectValue("birthDate", "required", "required");
		}
		
		
	}

}

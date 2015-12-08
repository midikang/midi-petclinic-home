package com.midi.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.Visit;
import com.midi.samples.petclinic.service.ClinicService;

@Controller
public class VisitController {

	private final ClinicService clinicService;

	@Autowired
	public VisitController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	
	/**
	 * Called before each and every @RequestMapping annotated method.
	 * 2 goals:
	 * - Make sure we always have fresh data
	 * - Since we do not use the session scope, make sure that Pet object always has an id
	 *  (Even though id is not part of the form fields)
	 * */
	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("petId") int petId) {
		Pet pet = this.clinicService.findPetById(petId);
		Visit visit = new Visit();
		pet.addVisit(visit);
		return visit;
	}
	
	// Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
	@RequestMapping(value = "/owners/*/pets/{petId}/visits/new", method=RequestMethod.GET)
	public String initNewVisitForm() {
		return "pets/createOrUpdateVisitForm";
	}

	// Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}/visits/new", method=RequestMethod.POST)
	public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
		if (result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		} else {
			this.clinicService.saveVisit(visit);
			return "redirect:/owners/{ownerId}";
		}
	}
	
	@RequestMapping(value = "/owners/*/pets/{petId}/visits", method = RequestMethod.GET)
	public String showVisits(@PathVariable("petId") int petId, Map<String, Object> model) {
		model.put("visits", this.clinicService.findPetById(petId).getVisits());
		return "visitList";
	}
	
}

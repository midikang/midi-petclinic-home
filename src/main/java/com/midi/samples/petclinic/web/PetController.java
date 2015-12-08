package com.midi.samples.petclinic.web;

import java.util.Collection;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.model.Pet;
import com.midi.samples.petclinic.model.PetType;
import com.midi.samples.petclinic.service.ClinicService;

/**
 * @ModelAttribute annotated method will be called before any @RequestMapping annotated methods, to expose variables to web view(form)
 * 
 * The value of RequestMapping is different from the value of return string to indicate view path
 * <br/>
 * e.g.
 * <br/>
 * /owners/{ownerId}/pets/new   -> action url
 * <br/>
 * pets/createOrUpdatePetForm  -> view url
 * 
 * 
 * @PathVariable
 * To get variable in the path.
 * <br/>
 * e.g.
 * <br/>
 * path
 * /owners/{ownerId}/pets/new
 * @PathVariable("ownerId") int ownerId
 * 
 * 
 * 
 * @author Midi Kang
 *
 */
@Controller
@SessionAttributes("pet")
public class PetController {
	
	private final ClinicService clinicService;
	
	@Autowired
	public PetController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	/**
	 * Will be called before @RequestMapping method, to expose 'types' to web view.
	 * 
	 * <petclinic:selectField label="Type" name="type" size="5" names="${types}"/>
	 * */
	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes() {
		Collection<PetType> petTypes= this.clinicService.findPetTypes();
		return petTypes;
	}
	
	/**
	 * populate form objects
	 * 1. disallow id field
	 * 2. add validator for pet.
	 * */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
		dataBinder.setValidator(new PetValidator());
	}
	

	// mapping /owners/{ownerId}/pets/new with GET
	
	/**
	 * mapping /owners/{ownerId}/pets/new with GET
	 * @param ownerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/owners/{ownerId}/pets/new", method = RequestMethod.GET)
	public String initCreateForm(@PathVariable("ownerId") int ownerId, Map<String, Object> model){
		Owner owner = this.clinicService.findOwnerById(ownerId);
		Pet pet = new Pet();
		owner.addPet(pet);
		model.put("pet", pet);
		return "pets/createOrUpdatePetForm";
	}
	
	/**
	 * mapping /owners/{ownerId}/pets/new with POST
	 * @param ownerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/owners/{ownerId}/pets/new", method = RequestMethod.POST)
	public String processCreateForm(@Valid Pet pet, BindingResult result, SessionStatus status){
		if (result.hasErrors()) {
			return "pets/createOrUpdatePetForm";
		} else {
			this.clinicService.savePet(pet);
			status.setComplete();
			return "redirect:/owners/{ownerId}";
		}
	}
	
	@RequestMapping(value ="/owners/*/pets/{petId}/edit", method = RequestMethod.GET)
	public String initUpdateForm(@PathVariable("petId")int petId, Map<String, Object> model){
		Pet pet = this.clinicService.findPetById(petId);
		model.put("pet", pet);
		return "pets/createOrUpdatePetForm";
	}
	
	/**
	 * 1. Validate pet.</br>
	 * 2. Save pet if no validation error.
	 * @return
	 */
	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}/edit", method = {RequestMethod.PUT, RequestMethod.POST})
	public String processUpdateForm(@Valid Pet pet, BindingResult result, SessionStatus status){
		if (result.hasErrors()) {
			return "pets/createOrUpdatePetForm";
		} else {
			this.clinicService.savePet(pet);
			status.setComplete();
			return "redirect:/owners/{ownerId}";
		}
	}
	
	
	
	
}

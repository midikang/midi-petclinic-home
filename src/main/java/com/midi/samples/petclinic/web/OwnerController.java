package com.midi.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.midi.samples.petclinic.model.Owner;
import com.midi.samples.petclinic.service.ClinicService;

/**
 * NOTE: Session attributes as indicated using this annotation correspond to 
 * a specific handler's model attributes, getting transparently stored in 
 * a conversational session. Those attributes will be removed once 
 * the handler indicates completion of its conversational session. 
 * 
 * BindingResult extends Errors
 * */
@Controller
@SessionAttributes(types=Owner.class)
public class OwnerController {
	
	private final ClinicService clinicService;
	
	@Autowired
	public OwnerController(ClinicService clinicService){
		this.clinicService = clinicService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value="/owners/new", method=RequestMethod.GET)
	public String initCreateForm(Map<String, Object> model) {
		Owner owner = new Owner();
		model.put("owner", owner);
		return "owners/createOrUpdateOwnerForm";
	}
	
	@RequestMapping(value="/owners/new", method=RequestMethod.POST)
	public String processCreateForm(@Valid Owner owner, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		} else {
			this.clinicService.saveOwner(owner);
			status.setComplete();
			return "redirect:/owners/" + owner.getId();
		}
	}

	@RequestMapping(value="/owners/find", method=RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("owner", new Owner());
		return "owners/findOwner";
	}

	@RequestMapping(value="owners", method=RequestMethod.GET)
	public String processFindForm(Owner owner, BindingResult result, Map<String, Object> model) {
		
		if (owner.getLastName() == null) {
			owner.setLastName("");
		}
		
		Collection<Owner> results =this.clinicService.findOwnerByLastName(owner.getLastName());
		if (results.isEmpty()) {
			result.rejectValue("lastName", "notFound","not found");
			return "owners/findOwner";
		} else if (results.size() == 1) {
			owner = results.iterator().next();
			return "redirect:owners/" + owner.getId();
		} else {
			model.put("selections", results);
			return "owners/ownerList";
		}
	}

	
	
	// /owners/{ownerId}/edit
	@RequestMapping(value = "/owners/{ownerId}/edit", method=RequestMethod.GET)
	public String initUpdateOwner(@PathVariable("ownerId") int ownerId, Model model) {
		Owner owner = this.clinicService.findOwnerById(ownerId);
		model.addAttribute(owner);
		return "owners/createOrUpdateOwnerForm";
	}
	
	@RequestMapping(value="/owners/{ownerId}/edit", method = RequestMethod.PUT)
	public String processUpdateOwner(@Valid Owner owner, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		} else {
			this.clinicService.saveOwner(owner);
			status.setComplete();
			return "redirect:/owners/{ownerId}";
		}
	}
	
	
	/**
	 * Displaying an owner.
	 * @return
	 */
	//@RequestMapping(value="/owners/{ownerId}", method=RequestMethod.GET)
    @RequestMapping("/owners/{ownerId}")
	public ModelAndView displayOwner(@PathVariable("ownerId") int ownerId){
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		mav.addObject(this.clinicService.findOwnerById(ownerId));
		return mav;
	}	

	

}

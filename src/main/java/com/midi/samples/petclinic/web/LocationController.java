package com.midi.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.midi.samples.petclinic.model.Location;
import com.midi.samples.petclinic.service.ClinicService;

@Controller
@SessionAttributes(types=Location.class)
public class LocationController {
	private final ClinicService clinicService;

	@Autowired
	public LocationController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@RequestMapping(value="locations/new", method=RequestMethod.GET)
	public String initCreateForm(Map<String, Object> model){
		Location location = new Location();
		model.put("location", location);
		return "locations/createOrUpdateLocationForm";
	}
	
	@RequestMapping(value="locations/new", method=RequestMethod.POST)
	public String processCreateForm(@Valid Location location, BindingResult result, SessionStatus status){
		if (result.hasErrors()) {
			return "locations/createOrUpdateLocationForm";
		} else {
			this.clinicService.saveLocation(location);
			status.setComplete();
			return "redirect:/locations/" + location.getId();
		}
	}
	
	@RequestMapping("/locations/{locationId}")
	public ModelAndView displayLocation(@PathVariable("locationId") int locationId) {
		ModelAndView mav = new ModelAndView("locations/locationDetails");
		mav.addObject(clinicService.findLocationById(locationId));
		return mav;
	}
}

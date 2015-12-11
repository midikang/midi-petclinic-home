package com.midi.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midi.samples.petclinic.model.Vet;
import com.midi.samples.petclinic.service.ClinicService;

@Controller
public class VetController {

	private final ClinicService clinicService;
	
	@Autowired
	public VetController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	@RequestMapping(value={"/vets.html"})
	public String showList(Map<String,Object > model){
		Collection<Vet> vetList = this.clinicService.findVets();
		model.put("vetList", vetList);
		return "vets/vetList";
	}
	
	
}

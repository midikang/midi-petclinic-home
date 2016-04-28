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

import com.midi.samples.petclinic.model.Zone;
import com.midi.samples.petclinic.service.YfsService;

@Controller
@SessionAttributes(types=Zone.class)
public class ZoneController {
	private final YfsService yfsService;
	
	@Autowired
	public ZoneController(YfsService yfsService) {
		this.yfsService = yfsService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@RequestMapping(value="zones/new", method=RequestMethod.GET)
	public String initCreateForm(Map<String, Object> model){
		Zone zone = new Zone();
		model.put("zone", zone);
		return "zones/createOrUpdateZoneForm";
	}
	
	@RequestMapping(value="zones/new", method=RequestMethod.POST)
	public String processCreateForm(@Valid Zone zone, BindingResult result, SessionStatus status){
		if (result.hasErrors()) {
			return "zones/createOrUpdateZoneForm";
		} else {
			this.yfsService.saveZone(zone);
			status.setComplete();
			return "redirect:/zones/" + zone.getId();
		}
	}
	
	@RequestMapping("/zones/{zoneId}")
	public ModelAndView displayZone(@PathVariable("zoneId") int zoneId) {
		ModelAndView mav = new ModelAndView("zones/zoneDetails");
		mav.addObject(yfsService.findZoneById(zoneId));
		return mav;
	}
	
}

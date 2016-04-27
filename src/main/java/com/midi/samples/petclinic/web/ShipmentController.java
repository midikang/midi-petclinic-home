package com.midi.samples.petclinic.web;

import java.util.Collection;
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

import com.midi.samples.petclinic.model.Shipment;
import com.midi.samples.petclinic.service.ClinicService;

@Controller
@SessionAttributes(types=Shipment.class)
public class ShipmentController {
	private final ClinicService clinicService;

	@Autowired
	public ShipmentController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	
	@RequestMapping(value="/shipments/new", method=RequestMethod.GET)
	public String initCreateForm(Map<String, Object> model) {
		Shipment shipment = new Shipment();
		model.put("shipment", shipment);
		return "shipments/createOrUpdateShipmentForm";
	}
	
	@RequestMapping(value="/shipments/new", method=RequestMethod.POST)
	public String processCreateForm(@Valid Shipment shipment , BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "shipments/createOrUpdateShipmentForm";
		} else {
			this.clinicService.saveShipment(shipment);
			status.setComplete();
			return "redirect:/shipments/" + shipment.getId();
		}
	}
	
	/**
	 * Displaying an shipment.
	 * @return
	 */
    @RequestMapping("/shipments/{shipmentId}")
	public ModelAndView displayShipment(@PathVariable("shipmentId") int shipmentId){
		ModelAndView mav = new ModelAndView("shipments/shipmentDetails");
		mav.addObject(this.clinicService.findShipmentById(shipmentId));
		return mav;
	}	

	@RequestMapping(value="/shipments/find", method=RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("shipment", new Shipment());
		return "shipments/findShipment";
	}

	@RequestMapping(value="shipments", method=RequestMethod.GET)
	public String processFindForm(Shipment shipment, BindingResult result, Map<String, Object> model) {
		
		if (shipment.getCustomerName() == null) {
			shipment.setCustomerName("");
		}
		
		Collection<Shipment> results =this.clinicService.findByCustomerName(shipment.getCustomerName());
		if (results.isEmpty()) {
			result.rejectValue("customerName", "notFound","not found");
			return "shipments/findShipment";
		} else if (results.size() == 1) {
			shipment = results.iterator().next();
			return "redirect:shipments/" + shipment.getId();
		} else {
			model.put("selections", results);
			return "shipments/shipmentList";
		}
	}


}

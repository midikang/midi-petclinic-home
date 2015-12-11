package com.midi.samples.petclinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vets {
	
	private List<Vet> vets;
	
	@XmlElement
	public List<Vet> getVetList() {
		if (vets == null) {
			vets = new ArrayList<Vet>();
		}
		
		return vets;
	}

}

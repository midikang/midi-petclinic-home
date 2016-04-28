package com.midi.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "yfs_location")
public class Location extends YFSEntity {
	
	@ManyToOne
	@JoinColumn(name = "zone_id")
	private Zone zone;
	
	@Column(name = "location_barcode")
	private String locationBarcode;
	
	@Column(name = "description")
	private String description;

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public String getLocationBarcode() {
		return locationBarcode;
	}

	public void setLocationBarcode(String locationBarcode) {
		this.locationBarcode = locationBarcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

package com.midi.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "yfs_location")
public class Location extends YFSEntity {
	
	@Column(name = "zone_id")
	private String zoneId;
	
	@Column(name = "location_barcode")
	private String locationBarcode;
	
	@Column(name = "description")
	private String description;

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
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

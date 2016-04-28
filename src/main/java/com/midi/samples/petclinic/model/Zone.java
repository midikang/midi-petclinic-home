package com.midi.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="yfs_zone")
public class Zone extends YFSEntity {
	
	@Convert(converter=BooleanToStringConverter.class)
	@Column(name="track_inventory")
	private Boolean trackInventory;
	
	@Column(name="description")
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getTrackInventory() {
		return trackInventory;
	}

	public void setTrackInventory(Boolean trackInventory) {
		this.trackInventory = trackInventory;
	}
	
}

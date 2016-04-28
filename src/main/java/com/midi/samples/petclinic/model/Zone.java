package com.midi.samples.petclinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name="yfs_zone")
public class Zone extends YFSEntity {
	
	@Column(name="zone_name")
	private String zoneName;
	
	@Convert(converter=BooleanToStringConverter.class)
	@Column(name="track_inventory")
	private Boolean trackInventory;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="zone")
	private Set<Location> locations;
	
	protected void setLocationsInternal(Set<Location> locations) {
		this.locations = locations;
	}
	
	protected Set<Location> getLocationsInternal() {
		if (this.locations == null || this.locations.isEmpty()) {
			this.locations = new HashSet<>();
		}
		return this.locations;
	}
	
	public List<Location> getLocations() {
		List<Location> sortedLocations = new ArrayList<>(getLocationsInternal());
		PropertyComparator.sort(sortedLocations, new MutableSortDefinition("name",true, true));
		return Collections.unmodifiableList(sortedLocations);
	}

	public void addLocation(Location location) {
		location.setZone(this);
		this.getLocationsInternal().add(location);
	}

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
	
	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	@Override
	public String toString() {
		return this.getZoneName();
	}
	
}

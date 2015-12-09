package com.midi.samples.petclinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name="owners")
public class Owner extends Person {

	@Column(name = "address")
	@NotEmpty
	private String address;
	
	@Column(name = "city")
	@NotEmpty
	private String city;
	
	@Column(name="telephone")
	@NotEmpty
	@Digits(fraction =0, integer=10)
	private String telephone;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private Set<Pet> pets;
	
	protected void setPetsInternal(Set<Pet> pets) {
		this.pets = pets;
	}

	protected Set<Pet> getPetsInternal() {
		if (this.pets == null || this.pets.isEmpty()) {
			this.pets = new HashSet<>();
		}
		return this.pets;
	}
	
	
	public List<Pet> getPets() {
		List<Pet> sortedPets = new ArrayList<>(getPetsInternal());
		PropertyComparator.sort(sortedPets, new MutableSortDefinition("name",true,true));
		return Collections.unmodifiableList(sortedPets);
	}

	
	
	public void addPet(Pet pet) {
		this.getPetsInternal().add(pet);
		pet.setOwner(this);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Owner [address=" + address + ", city=" + city + ", telephone=" + telephone + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", id=" + id + ", isNew()=" + isNew() + "]";
	}


	public Pet getPet(String name) {
		return getPet(name, false);
	}
	
	/**
	 * 
	 * Used for pet validation
	 * 
	 * @param name
	 * @param ignoreNew
	 * @return
	 */
	public Pet getPet(String name, boolean ignoreNew) {
		name = name.toLowerCase();
		for(Pet pet : getPetsInternal()) {
			if(!ignoreNew && pet.getName().toLowerCase().equals(name)) {
				return pet;
			}
		}
		return null;
	}
	
	
	
	
	
}

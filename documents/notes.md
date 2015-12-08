org.springframework.beans.NotReadablePropertyException: Invalid property 'type' of bean class [com.midi.samples.petclinic.model.Pet]: Bean property 'type' is not readable or has an invalid getter method: Does the return type of the getter match the parameter type of the setter?
	org.springframework.beans.BeanWrapperImpl.getPropertyValue(BeanWrapperImpl.java:731)
	

<petclinic:selectField label="Type" name="type" size="5" names="${types}"/>

if entity class Pet
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

Solution
--------
1. Change field petType to type,and regenerate getter/setter.
2. Or, 	change type to petType in <petclinic:selectField label="Type" name="type" size="5" names="${types}"/>
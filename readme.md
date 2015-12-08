Steps
----------
* Copy pom.xml
* Copy web.xml
* Create class RootApplicationContextConfig
* Import BusinessConfig into RootApplicationContextConfig
* Import JpaConfig into BusinessConfig
* Create transactionManager in JpaConfig
* Define package to be scanned for jpa repository
* Create class MvcCoreConfig
* Add Owner entity
* Add OwnerRepository interface
* Add JpaOwnerRepository implementation
* Add ClinicService service
* Add ClinicServiceImpl implementation

Entities graph
----------
* BaseEntity is the root for all the other entities.
* NamedEntity extends BaseEntity, all the other entities which only have name, should extends from NamedEntity.
* Person extends BaseEntity.
* Owner extends Person, has OneToMany with pet.
* Pet extends NamedEntity, has OneToMany with visit.
* Visit extends BaseEntity, has ManyToOne with Pet.
* Vet extends Person.
* Specialty extends NamedEntity.
*
 



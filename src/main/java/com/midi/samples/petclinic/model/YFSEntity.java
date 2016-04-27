package com.midi.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;

@MappedSuperclass
public class YFSEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "enterprise")
	private String enterprise;
	
	@Column(name = "node")
	private String node;
	
	@Column(name = "createts")
	private DateTime createDate;
	
	@Column(name = "modifyts")
	private DateTime modifyDate;

	public boolean isNew() {
		return (this.id== null);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public DateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(DateTime createDate) {
		this.createDate = createDate;
	}

	public DateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(DateTime modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
}

package com.midi.wms.yfs.model;

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
	
	@Column(name = "createts")
	private DateTime createDate;
	
	@Column(name = "modifyts")
	private DateTime modifyDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public boolean isNew() {
		return (this.id== null);
	}
	
}

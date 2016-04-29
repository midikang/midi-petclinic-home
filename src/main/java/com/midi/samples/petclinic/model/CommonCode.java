package com.midi.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="yfs_common_code")
public class CommonCode  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="code_type")
	private String codeType;
	
	@Column(name="code_value")
	private String codeValue;
	
	@Column(name = "createts")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private DateTime createDate;
	
	@Column(name = "modifyts")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private DateTime modifyDate;

	public boolean isNew() {
		return (this.id== null);
	}
	
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

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
	
	@Override
	public String toString() {
		return this.getCodeValue();
	}
}

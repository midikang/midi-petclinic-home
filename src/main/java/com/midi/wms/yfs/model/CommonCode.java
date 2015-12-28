package com.midi.wms.yfs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="commoncodes")
public class CommonCode extends YFSEntity {

	@Column(name="code_type")
	@NotEmpty
	private String codeType;
	
	@Column(name="code_value")
	@NotEmpty
	private String codeValue;
	
	@Column(name="code_description")
	private String codeDescription;

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

	public String getCodeDescription() {
		return codeDescription;
	}

	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}
	
	
	
}

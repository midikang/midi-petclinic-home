package com.midi.wms.yfs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "yfs_document_type")
public class DocumentType extends YFSEntity {
	
	@Column(name = "document_type")
	private String documentType;

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
}

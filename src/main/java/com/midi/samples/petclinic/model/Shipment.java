package com.midi.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "yfs_shipment")
public class Shipment extends YFSEntity {
	//private DocumentType documentType;
	
	@Column(name = "shipment_no")
	private String shipmentNo;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "ship_node")
	private String shipNode;
	
	@Column(name = "document_type")
	private String documentType;
	
	public String getShipNode() {
		return shipNode;
	}
	public void setShipNode(String shipNode) {
		this.shipNode = shipNode;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getShipmentNo() {
		return shipmentNo;
	}
	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}

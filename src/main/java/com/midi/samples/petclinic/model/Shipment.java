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

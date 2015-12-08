package com.midi.wms.yfs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "yfs_shipment")
public class Shipment extends YFSEntity {
	private DocumentType documentType;
}

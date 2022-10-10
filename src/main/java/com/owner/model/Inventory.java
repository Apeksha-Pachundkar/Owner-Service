package com.owner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Inventory")
public class Inventory {
     
	@Id
	private int inventory_id;
	private String inventory_name;
	
	
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(int inventory_id, String inventory_name) {
		super();
		this.inventory_id = inventory_id;
		this.inventory_name = inventory_name;
	}
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public String getInventory_name() {
		return inventory_name;
	}
	public void setInventory_name(String inventory_name) {
		this.inventory_name = inventory_name;
	}
	@Override
	public String toString() {
		return "Inventory [inventory_id=" + inventory_id + ", inventory_name=" + inventory_name + "]";
	}
	
	
	
}

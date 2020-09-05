package com.finalProject.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@IdClass(PK_Card.class)
@Table(name = "WantList")
public class WantListItem 
{
	//Key values
	@Id
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@Id
	@Column(name = "setCode", length = 4)
	private String setCode;
	@Id
	@Column(name = "rarity", length = 20)
	private String rarity;
	@Id
	@Column(name = "printing")
	private String printing;
	@Basic
	@Column(name = "quantity")
	private int quantity;
	
	public WantListItem(String name, String setCode, int quantity, String rarity, String printing) {
		super();
		this.name = name;
		this.setCode = setCode;
		this.quantity = quantity;
		this.rarity = rarity;
		this.printing = printing;		
	}
	
	public WantListItem() {
		super();
		this.name = "";
		this.setCode = "";
		this.quantity = 0;
		this.rarity = "";
		this.printing = "Unlimited";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSetCode() {
		return setCode;
	}

	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getPrinting() {
		return printing;
	}

	public void setPrinting(String printing) {
		this.printing = printing;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addCopies(int numCopies) {
		this.quantity += numCopies;
	}

	public void removeCopies(int numCopies) {
		if(numCopies >= this.quantity)
			this.quantity = 0;
		else
			this.quantity -= numCopies;
	}
	
	public String toString()
	{
		return "Name: " + this.name + "\n" + "Set Code: " + this.setCode + "\nQuantity: " + this.quantity;
	}
	
}

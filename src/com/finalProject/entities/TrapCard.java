package com.finalProject.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Trap")
@Table(name="Card")
public class TrapCard extends Card{
	public static enum Category{
		NORMAL,
		CONTINUOUS,
		COUNTER
	}
	
	@Basic
	@Column(name = "category")
	private Category category;

	public TrapCard(String name, String setCode, String type, int quantity, String print, String rarity, Category category) {
		super(name, setCode, type, quantity, rarity, print);
		this.category = category;
	}

	public TrapCard() {
		super();
		category = Category.NORMAL;
	}

	@Override
	public String getCardType() {
		return "Trap";
	}
	
}
package com.finalProject.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Spell")
@Table(name="Card")
public class SpellCard extends Card{
	public static enum Category{
		NORMAL,
		QUICK,
		FIELD,
		RITUAL,
		EQUIP,
		CONTINUOUS
	}
	
	@Basic
	@Column(name = "category")
	private Category category;

	public SpellCard(String name, String setCode, String type, int quantity, String print, String rarity, Category category) {
		super(name, setCode, type, quantity, rarity, print);
		this.category = category;
	}

	public SpellCard() {
		super();
		category = Category.NORMAL;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCardType() {
		return "Spell";
	}
	
}

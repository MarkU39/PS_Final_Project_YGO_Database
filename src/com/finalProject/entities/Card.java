package com.finalProject.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@IdClass(PK_Card.class)
@Inheritance
@DiscriminatorColumn(name = "cardType")
@Table(name="Card")
public class Card {
	
	public enum Condition{
		NEARMINT,
		LP,
		MP,
		DAMAGED
	}
	
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
	
	
	
	//Non-key values
	@Basic
	@Column(name = "quantity")
	private int quantity;
	
	
	
	public Card(String name, String setCode, String type, int quantity, String rarity, String printing) {
		super();
		this.name = name;
		this.setCode = setCode;
		this.quantity = quantity;
		this.rarity = rarity;
		this.printing = printing;		
	}
	
	public Card() {
		super();
		this.name = "";
		this.setCode = "";
		this.quantity = 1;
		this.rarity = "";
		this.printing = "Unlimited";
	}

	public String getPrinting() {
		return printing;
	}

	public void setPrinting(String printing) {
		this.printing = printing;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getRarity(){
		return rarity;
	}
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	public String getCardType()
	{
		if(this instanceof MonsterCard)
			return "Monster";
		else if(this instanceof SpellCard)
			return "Spell";
		else if(this instanceof TrapCard)
			return "Trap";
		else
			return "Unspecified";
	}
	
	@Override
	public boolean equals(Object card)
	{
		//We can consider cards to be the same if they have the same name, rarity and set code.
		//Other than that, I won't worry about quantity because we could have two objects with the same
		//card but different quantities, but all we want to know is if they are talking about the 
		//same card.
		Card castCard = (Card)card;
		return this.name.equals(castCard.getName()) && this.rarity.equals(castCard.getRarity()) && this.setCode.equals(castCard.getSetCode()) && this.getPrinting().equals(castCard.getPrinting());
	}

	public void addCopies(int numCopies) {
		quantity += numCopies;		
	}
	
	public void removeCopies(int numCopies)
	{
		if(numCopies >= quantity)
			quantity = 0;
		else
			quantity -= numCopies;
	}
	
	public String toString()
	{
		return "Name: " + this.name + "\n" + "Set Code: " + this.setCode + "\nQuantity: " + this.quantity;
	}
	
	public boolean isExtra()
	{
		if(this instanceof SpellCard || this instanceof TrapCard)
			return false;
		else if(((MonsterCard)this).isMainDeck())
			return false;
		else
			return true;
	}
}

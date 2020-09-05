package com.finalProject.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Monster")
@Table(name="Card")
public class MonsterCard extends Card {
	
	public static enum Attribute{
		LIGHT,
		DARK,
		WATER,
		EARTH,
		FIRE,
		WIND,
		DIVINE
	}
	
	public static enum Category{
		NORMAL,
		EFFECT,
		FUSION,
		RITUAL,
		SYNCHRO,
		XYZ,
		PENDULUM,
		LINK,
		GEMINI,
		SPIRIT,
		UNION,
		TOON
	}
	
	@Basic
	@Column(name = "atk")
	private int atk;
	@Basic
	@Column(name = "def")
	private int def;
	@Basic
	@Column(name = "lv")
	private int lv;
	@Basic
	@Column(name = "attribute")
	private Attribute attribute;
	@Basic
	@Column(name = "category")
	private Category category;
	
	//This refers to the monster type, e.g. Spellcaster, Warrior, etc.
	@Basic
	@Column(name = "monsterType")
	private String monsterType;
	
	public MonsterCard(String name, String setCode, String type, int quantity, String rarity, String print, String monsterType, int atk, int def, int lv, Attribute attribute, Category category) {
		super(name, setCode, type, quantity, rarity, print);
		this.atk = atk;
		this.def = def;
		this.lv = lv;
		this.attribute = attribute;
		this.category = category;
		this.monsterType = monsterType;
	}

	public MonsterCard() {
		super();
		this.atk = 0;
		this.def = 0;
		this.lv = 1;
		this.attribute = Attribute.LIGHT;
		this.category = Category.NORMAL;
		this.monsterType = "";
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public boolean isMainDeck()
	{
		return (this.category != Category.LINK && this.category != Category.SYNCHRO && this.category != Category.XYZ && this.category != Category.FUSION);
	}

	@Override
	public String getCardType() {
		return "Monster";
	}
}

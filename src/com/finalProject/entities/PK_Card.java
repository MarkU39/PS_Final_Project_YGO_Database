package com.finalProject.entities;

import javax.persistence.Column;
import javax.persistence.Id;

//import com.finalProject.entities.Card.Condition;


public class PK_Card implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public PK_Card(String name, String setCode, String rarity, String printing)
	{
		this.name = name;
		this.setCode = setCode;
		this.rarity = rarity;
		this.printing = printing;
	}
	
	public PK_Card()
	{
		this.name = "";
		this.setCode = "";
		this.rarity = "";
		this.printing = "Unlimited";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((printing == null) ? 0 : printing.hashCode());
		result = prime * result + ((rarity == null) ? 0 : rarity.hashCode());
		result = prime * result + ((setCode == null) ? 0 : setCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PK_Card other = (PK_Card) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (printing != other.printing)
			return false;
		if (rarity == null) {
			if (other.rarity != null)
				return false;
		} else if (!rarity.equals(other.rarity))
			return false;
		if (setCode == null) {
			if (other.setCode != null)
				return false;
		} else if (!setCode.equals(other.setCode))
			return false;
		return true;
	}
	
}

package com.finalProject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Deck {
	@Transient
	private static final int SIDE_MAX_SIZE = 15;
	@Transient
	private static final int EXTRA_MAX_SIZE = 15;
	@Transient
	private static final int MAIN_MAX_SIZE = 60;
	
	@Id
	@Column(name = "Name") 
	private String name;
	
	@Basic
	@Column(name = "mainDeck")
	private List<Card> mainDeck;
	
	@Basic
	@Column(name = "extraDeck")
	private List<Card> extraDeck;
	
	@Basic
	@Column(name = "sideDeck")
	private List<Card> sideDeck;
	 
	//Default Constructor
	public Deck()
	{
		setMain(new ArrayList<Card>());
		setExtra(new ArrayList<Card>());
		setSide(new ArrayList<Card>());
		this.setName("");
	}
	
	//Constructor with arguments
	public Deck(String name)
	{
		setMain(new ArrayList<Card>());
		setExtra(new ArrayList<Card>());
		setSide(new ArrayList<Card>());
		this.setName(name);
	}

	public List<Card> getMain() {
		return mainDeck;
	}

	public void setMain(List<Card> mainDeck) {
		this.mainDeck = mainDeck;
	}

	public List<Card> getExtra() {
		return extraDeck;
	}

	public void setExtra(List<Card> extraDeck) {
		this.extraDeck = extraDeck;
	}

	public List<Card> getSide() {
		return sideDeck;
	}

	public void setSide(List<Card> sideDeck) {
		this.sideDeck = sideDeck;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Takes: a Card
	//Returns: the number of copies of that Card in the side,
	//extra, and main decks combined
	private int findTotalNumCopies(Card card)
	{
		int numCopies = 0;
		
		//Check the main, and count the quantity in there
		for(Card c : mainDeck)
		{
			if(c.getName().equals(card.getName()));
			{
				numCopies += c.getQuantity();
			}
		}
		//Then check the side, and do likewise
		for(Card c : sideDeck)
		{
			if(c.getName().equals(card.getName()));
			{
				numCopies += c.getQuantity();
			}
		}
		//Then check the extra, and do likewise
		for(Card c : extraDeck)
		{
			if(c.getName().equals(card.getName()));
			{
				numCopies += c.getQuantity();
			}
		}
		
		return numCopies;
	}
	
	private boolean attemptInsert(Card card, List<Card> deck, int max)
	{
		if(card.getQuantity() > 3)
		{
			return false;
		}
		if(deck.size() > max - card.getQuantity())
		{
			//Not enough room for this card, return false
			return false;
		}
		//Find out if the card is already in the deck,
		//and if not, insert, and if so, increment
		int i = deck.indexOf(card);
		if(i == -1)
		{
			return deck.add(card);
		}
		else
		{
			deck.get(i).addCopies(card.getQuantity());
			return true;
		}
	}
	
	public boolean add_card(Card card, boolean side) {
		//First, check to see if we can put any more copies of this card
		//in this deck.
		int currentCount = this.findTotalNumCopies(card);
		if(currentCount == 3)
		{
			return false;
		}
		//The user could also try to add too many copies of the card.
		//If so, they shouldn't be able to do this, so I'll just return
		//false as well.
		else if(currentCount + card.getQuantity() > 3)
		{
			return false;
		}
		else	//The user is allowed more copies of this card
		{		//Find out if there's room for it (wherever it goes)
				//and, if there is, put it there.
			if(side) {
				return attemptInsert(card, sideDeck, SIDE_MAX_SIZE);
			}
			else
			{
				if(card instanceof SpellCard || card instanceof TrapCard)
				{
					return attemptInsert(card, mainDeck, MAIN_MAX_SIZE);
				}
				//we must have a monster here, so we'll check to see if it's
				//an extra deck monster or main deck monster
				else if(((MonsterCard) card).isMainDeck())
				{
					return attemptInsert(card, mainDeck, MAIN_MAX_SIZE);
				}
				//If we've gotten here, we have an extra deck monster. 
				//Try the insert there instead
				else
				{
					return attemptInsert(card, extraDeck, EXTRA_MAX_SIZE);
				}
			}
		}
	}
	
	public boolean remove_card(Card card, List<Card> deck)
	{
		boolean found = false;
		for(Card cardInDeck : deck)
		{
			if(cardInDeck.getName() == card.getName())
			{
				cardInDeck.removeCopies(card.getQuantity());
				if(cardInDeck.getQuantity() == 0)
				{
					deck.remove(cardInDeck);
				}
				found = true;
				break;
			}	
		}
		return found;
	}

	
}

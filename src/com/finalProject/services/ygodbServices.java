package com.finalProject.services;

import com.finalProject.entities.Card;
import com.finalProject.entities.Deck;
import com.finalProject.entities.WantListItem;

import java.util.List;

import com.finalProject.dao.ygodbDAO;

public class ygodbServices {
	public static ygodbDAO dao = new ygodbDAO();
	
	public boolean addCardToCollection(Card card)
	{
		return dao.addCardToCollection(card);
	}
	
	public Card deleteCard(Card card)
	{
		return dao.deleteCard(card);
	}
	
	public Card getCardFromCollByCardInfo(String cardName, String rarity, String setCode, String printing)
	{
		return dao.getCardFromCollByCardInfo(cardName, rarity, setCode, printing);
	}
	
	public List<Card> getAllCardsInCollection()
	{
		return dao.getAllCardsInCollection();
	}
	
	public List<Card> searchInCollection(String partialName, String rarity, String setCode, String printing)
	{
		return dao.searchInCollection(partialName, rarity, setCode, printing);
	}
	
	public boolean createNewDeck(String name)
	{
		return dao.createNewDeck(name);
	}
	
	public boolean addCardToDeck(Deck deck, Card card, boolean side)
	{
		return dao.addCardToDeck(deck, card, side);
	}
	
	public Deck getDeckByName(String name)
	{
		return dao.getDeckByName(name);
	}
	
	public List<Deck> getAllDecks()
	{
		return dao.getAllDecks();
	}
	
	public boolean addCardToWantList(Card card)
	{
		return dao.addCardToWantList(card);
	}
	
	public WantListItem removeCardFromWantList(Card card)
	{
		return dao.removeCardFromWantList(card);
	}
	
	public List<WantListItem> getWantList()
	{
		return dao.getWantList();
	}
}

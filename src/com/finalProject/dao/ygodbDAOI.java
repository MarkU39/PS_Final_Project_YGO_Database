package com.finalProject.dao;

import java.util.List;
import com.finalProject.entities.Card;
import com.finalProject.entities.Deck;
import com.finalProject.entities.WantListItem;

public interface ygodbDAOI {
	
	//-------------------------------------------------------------------------------------------------
	//	Collection Tracker functions
	//-------------------------------------------------------------------------------------------------
	
	//These two methods handle creation and deletion, but also updates.
	//In general, we don't want to change the names of cards in the database.
	//All we would want to do is modify the number of copies, which we can
	//logically do in the add and delete functions. 
	
	public boolean addCardToCollection(Card card);
	public Card deleteCard(Card card);
	
	public Card getCardFromCollByCardInfo (String cardName, String rarity, String setCode, String printing);
	public List<Card> getAllCardsInCollection();
	public List<Card> searchInCollection(String partialName, String rarity, String setCode, String printing);
	
	//-------------------------------------------------------------------------------------------------
	//	Deck Tracker functions
	//-------------------------------------------------------------------------------------------------
	
	public List<Deck> getAllDecks();
	public boolean createNewDeck(String name);
	public boolean addCardToDeck(Deck deck, Card card, boolean side);
	public boolean removeCardFromDeck(Deck deck, Card card, boolean side);
	public Deck getDeckByName(String name);

	//-------------------------------------------------------------------------------------------------
	//	Want List Tracker functions
	//-------------------------------------------------------------------------------------------------
	public boolean addCardToWantList(Card card);
	public WantListItem removeCardFromWantList(Card card);
	public List<WantListItem>getWantList();
	
}

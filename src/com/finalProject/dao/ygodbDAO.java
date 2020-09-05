package com.finalProject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.finalProject.entities.Card;
import com.finalProject.entities.Deck;
import com.finalProject.entities.PK_Card;
import com.finalProject.entities.WantListItem;

public class ygodbDAO implements ygodbDAOI {

	private final static String UNIT_NAME = "FinalProjectYGODatabase";
	
	//-------------------------------------------------------------------------------------------------
	//	Collection Tracker functions
	//-------------------------------------------------------------------------------------------------
	
	@Override
	public boolean addCardToCollection(Card card) {
		boolean result = false;
		
		//It doesn't make sense to add a non-positive value; that should be a removal.
		//Disallow it here.
		if(card.getQuantity() <= 0)
		{
			return result;
		}
		
		//Create the entity managers
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		try
		{
			//Attempt a search for the card in the database
			PK_Card key = new PK_Card(card.getName(), card.getSetCode(), card.getRarity(), card.getPrinting());
			Card found = em.find(Card.class, key);
			if(found == null)
			{
				//if we don't find the card in the database, persist the new card
				em.getTransaction().begin();
				em.persist(card);
				em.getTransaction().commit();
			}
			else
			{
				//if we do find the card, increment the number of copies of it.
				em.getTransaction().begin();
				found.addCopies(card.getQuantity());
				em.getTransaction().commit();
			}
			
			result = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		return result;
	}

	@Override
	public Card deleteCard(Card card) {
		Card retCard = null;
		
		//It doesn't make sense to remove a non-positive value; that would be an addition.
		//Disallow it here
		if(card.getQuantity() <= 0)
		{
			return retCard;
		}
		
		//Create the entity managers
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		try
		{
			//Attempt to find the card in the database
			PK_Card key = new PK_Card(card.getName(), card.getSetCode(), card.getRarity(), card.getPrinting());
			retCard = em.find(Card.class, key);
			//We've found the card
			if(retCard != null)
			{
				if(card.getQuantity() >= retCard.getQuantity())
				{
					//We're removing every copy of this card. Just delete the whole thing.
					System.out.println(retCard.toString());
					em.getTransaction().begin();
					em.remove(retCard);
					em.getTransaction().commit();
				}
				else
				{
					em.getTransaction().begin();
					retCard.removeCopies(card.getQuantity());
					em.getTransaction().commit();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		return retCard;
	}

	@Override
	public Card getCardFromCollByCardInfo(String cardName, String rarity, String setCode, String printing) {
		Card retCard = null;
		
		//Create the entity managers
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
			
		try
		{
			//Attempt to find the card in the database
			PK_Card key = new PK_Card(cardName, setCode, rarity, printing);
			retCard = em.find(Card.class, key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		//If the card isn't found in the database, this will just be null
		return retCard;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Card> getAllCardsInCollection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		List<Card> collection = new ArrayList<Card>();
		try 
		{
			String statement = "SELECT c FROM Card c";
			Query query = em.createQuery(statement);
			collection = query.getResultList();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			em.close();
			emf.close();
		}
		return collection;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Card> searchInCollection(String partialName, String rarity, String setCode, String printing) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		List<Card> results = new ArrayList<Card>();
		try 
		{
			String stm = "SELECT c FROM Card c WHERE ";
			if(partialName != "")
				stm += "c.name LIKE :partialName AND ";
			if(rarity != "")
				stm += "c.rarity = :rarity AND ";
			if(setCode != "")
				stm += "c.setCode LIKE :setCode AND ";
			if(printing != "")
				stm += "c.printing = :printing";
			
			stm = stm.trim();
			System.out.println(stm);
			
			if(stm.endsWith("AND"))
				stm = stm.substring(0,  stm.length() - 3);
			if(stm.endsWith("WHERE"))
				stm = stm.substring(0, stm.length() - 5);
			
			Query query = em.createQuery(stm);
			if(partialName != "")
				query.setParameter("partialName", "%" + partialName + "%");
			if(rarity != "")
				query.setParameter("rarity", rarity);
			if(setCode != "")
				query.setParameter("setCode", "%" + setCode + "%");
			if(printing != "")
				query.setParameter("printing", printing);
			
			
			results = query.getResultList();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		
		return results;
	}

	//-------------------------------------------------------------------------------------------------
	//	Deck Tracker functions
	//-------------------------------------------------------------------------------------------------
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Deck> getAllDecks()
	{
		List<Deck> allDecks = null;
		
		//Create the entity managers
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		try 
		{
			String statement = "SELECT d FROM Deck d";
			Query query = em.createQuery(statement);
			allDecks = query.getResultList();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			em.close();
			emf.close();
		}	
		return allDecks;
	}
	
	@Override
	public boolean createNewDeck(String name) {
		boolean created = false;
		
		//Create the entity managers
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		//Check to see if the deck is already in the database
		try
		{
			Deck found = em.find(Deck.class, name);
			if(found == null)
			{
				//if we don't find the deck, create it
				em.getTransaction().begin();
				Deck newDeck = new Deck(name);
				em.persist(newDeck);
				em.getTransaction().commit();
				created = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		return created;
	}

	@Override
	public boolean addCardToDeck(Deck deck, Card card, boolean side) {
		return deck.add_card(card, side);
	}

	@Override
	public boolean removeCardFromDeck(Deck deck, Card card, boolean side) {
		if(side)
			return deck.remove_card(card, deck.getSide());
		else if(card.isExtra())
			return deck.remove_card(card, deck.getExtra());
		else
			return deck.remove_card(card, deck.getMain());
	}

	@Override
	public Deck getDeckByName(String name) {
		Deck found = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		//Check to see if the deck is already in the database
		try
		{
			found = em.find(Deck.class, name);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		return found;
	}

	//-------------------------------------------------------------------------------------------------
	//	Want List Tracker functions
	//-------------------------------------------------------------------------------------------------

	public boolean addCardToWantList(Card card)
	{
		boolean result = false;
		
		//It doesn't make sense to add a non-positive value; that should be a removal.
		//Disallow it here.
		if(card.getQuantity() <= 0)
		{
			return result;
		}
		
		//Create the entity managers
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		try
		{
			//Attempt a search for the card in the database
			PK_Card key = new PK_Card(card.getName(), card.getSetCode(), card.getRarity(), card.getPrinting());
			WantListItem newItem = new WantListItem(card.getName(), card.getSetCode(), card.getQuantity(), card.getRarity(), card.getPrinting());
			WantListItem found = em.find(WantListItem.class, key);
			if(found == null)
			{
				//if we don't find the card in the database, persist the new card
				em.getTransaction().begin();
				em.persist(newItem);
				em.getTransaction().commit();
			}
			else
			{
				//if we do find the card, increment the number of copies of it.
				em.getTransaction().begin();
				found.addCopies(card.getQuantity());
				em.getTransaction().commit();
			}
			result = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		return result;
	}
	public WantListItem removeCardFromWantList(Card card)
	{
		WantListItem retCard = null;
		
		//It doesn't make sense to remove a non-positive value; that would be an addition.
		//Disallow it here
		if(card.getQuantity() <= 0)
		{
			return retCard;
		}
		
		//Create the entity managers
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		try
		{
			//Attempt to find the card in the database
			PK_Card key = new PK_Card(card.getName(), card.getSetCode(), card.getRarity(), card.getPrinting());
			retCard = em.find(WantListItem.class, key);
			//We've found the card
			System.out.println("Result: \n");
			System.out.println(retCard.toString());
			if(retCard != null)
			{
				if(card.getQuantity() >= retCard.getQuantity())
				{
					//We're removing every copy of this card. Just delete the whole thing.
					System.out.println(retCard.toString());
					em.getTransaction().begin();
					em.remove(retCard);
					em.getTransaction().commit();
				}
				else
				{
					em.getTransaction().begin();
					retCard.removeCopies(card.getQuantity());
					em.getTransaction().commit();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		return retCard;
	}
	
	@SuppressWarnings("unchecked")
	public List<WantListItem> getWantList()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		List<WantListItem> wantList = new ArrayList<WantListItem>();
		try 
		{
			String statement = "SELECT w FROM WantListItem w";
			Query query = em.createQuery(statement);
			wantList = query.getResultList();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			em.close();
			emf.close();
		}
		return wantList;
	}
	
}

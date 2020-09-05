package com.finalProject.testing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.finalProject.dao.*;
import com.finalProject.entities.Card;
//import com.finalProject.entities.PK_Card;
import com.finalProject.entities.SpellCard;
//import com.finalProject.entities.Card.Condition;
//import com.finalProject.entities.Card.Printing;



public class testRemoveCardFromCollection {
	private static ygodbDAO dao;
	private static Card cardInDB;
	private static Card cardNotInDB;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ygodbDAO();
		cardInDB = new SpellCard("Dark Ruler No More", "TN19", "Spell", 1, "LIMITED", "Prismatic Secret", SpellCard.Category.NORMAL);
		cardNotInDB = new SpellCard("Bark Buler Bo Bore", "TN19", "Spell", 1, "LIMITED", "Prismatic Secret", SpellCard.Category.NORMAL);
		dao.addCardToCollection(cardInDB);	//this way we know that the card is in the database
	}
	
	@Test
	public void testRemoveACardInTheDatabase() {
		Card removedCard = dao.deleteCard(cardInDB);
		assertEquals(removedCard, cardInDB);
	}
	
	@Test
	public void testRemoveACardNotInTheDatabase() {
		Card removedCard = dao.deleteCard(cardNotInDB);
		assertNull(removedCard);
	}
}

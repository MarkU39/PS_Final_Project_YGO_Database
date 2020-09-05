package com.finalProject.testing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.finalProject.dao.ygodbDAO;
import com.finalProject.entities.Deck;
import com.finalProject.entities.MonsterCard;
import com.finalProject.entities.Card;

public class testDeckClass {

	private static ygodbDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ygodbDAO();
		dao.createNewDeck("Six Samurai");
		dao.createNewDeck("Shaddoll Invoked");
		dao.createNewDeck("Altergeists");
		dao.createNewDeck("Burning Abyss");
	}

	@Test
	public void test() {
		Card onecard = new MonsterCard("The Legendary Six Samurai - Kizan", "SPWA", "Monster", 1, "Super", "1st", "Warrior", 1800, 300, 4, MonsterCard.Attribute.EARTH, MonsterCard.Category.EFFECT);
		Card twocard = new MonsterCard("The Legendary Six Samurai - Shi En", "SPWA", "Monster", 1, "Super", "1st", "Warrior", 2500, 400, 5, MonsterCard.Attribute.DARK, MonsterCard.Category.SYNCHRO);
		
		Deck deck = dao.getDeckByName("Six Samurai");
		deck.add_card(onecard, false);
		deck.add_card(onecard, true);
		deck.add_card(twocard, false);
		
	}
	
	@Test
	public void test2() {
		Deck deck = dao.getDeckByName("Six Samurai");
		for(Card c : deck.getMain())
		{
			System.out.println(c.toString());
		}
	}

}

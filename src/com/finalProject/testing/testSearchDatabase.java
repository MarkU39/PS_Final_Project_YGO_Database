package com.finalProject.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.finalProject.dao.ygodbDAO;
import com.finalProject.entities.Card;
import com.finalProject.entities.MonsterCard;
//import com.finalProject.entities.Card.Printing;
import com.finalProject.entities.MonsterCard.Attribute;
import com.finalProject.entities.MonsterCard.Category;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testSearchDatabase {

	private static Category cat;
	private static Attribute att;
	private static String prt;
	private static ygodbDAO dao;
	
	@BeforeClass
	public static void setUp() throws Exception {
		cat = Category.LINK;
		att = Attribute.WIND;
		prt = "FIRST";
		dao = new ygodbDAO();
		Card card = new MonsterCard("Apollousa, Bow of the Goddess", "RIRA", "Monster", 1, "Secret", prt, "Fairy", 0, 0, 4, att, cat);
		Card card2 = new MonsterCard("Apollousa, Bow of the Goddess", "MP20", "Monster", 1, "Ultra", prt, "Fairy", 0, 0, 4, att, cat);
		Card card3 = new MonsterCard("Gizmek Orochi, the Serpentron Sky Slasher", "RIRA", "Monster", 1, "Secret", prt, "Machine", 2450, 2450, 8, Attribute.DARK, Category.EFFECT);
		dao.addCardToCollection(card);
		dao.addCardToCollection(card2);
		dao.addCardToCollection(card3);
	}

	@Test
	public void testSearchFullInfo() {
		System.out.println("Beginning test of full info...");
		List<Card> results = dao.searchInCollection("Apollousa, Bow of the Goddess", "Secret", "RIRA", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
	
	@Test
	public void testSearchAnyRarity() {
		System.out.println("Beginning test of any rarity...");
		List<Card> results = dao.searchInCollection("Apollousa, Bow of the Goddess", "any", "RIRA", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
	
	@Test
	public void testSearchAnySet() {
		System.out.println("Beginning test of any set...");
		List<Card> results = dao.searchInCollection("Apollousa, Bow of the Goddess", "Secret", "any", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
	
	@Test
	public void testSearchMultipleResults() {
		System.out.println("Beginning test of multiple results...");
		List<Card> results = dao.searchInCollection("Apollousa, Bow of the Goddess", "any", "any", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
	
	@Test
	public void testSearchAnyName() {
		System.out.println("Beginning test of any name...");
		List<Card> results = dao.searchInCollection("", "Secret", "RIRA", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
	
	@Test
	public void testSearchNoResults() {
		System.out.println("Beginning test of no results...");
		List<Card> results = dao.searchInCollection("Bizmek Borochi", "Secret", "RIRA", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
	
	@Test
	public void testSearchPartialNameBeginning() {
		System.out.println("Beginning test of partial name (beginning)...");
		List<Card> results = dao.searchInCollection("Apollousa", "Secret", "RIRA", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
	
	@Test
	public void testSearchPartialNameEnd() {
		System.out.println("Beginning test of partial name (end)...");
		List<Card> results = dao.searchInCollection("Goddess", "Secret", "RIRA", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
	
	@Test
	public void testSearchPartialNameMiddle() {
		System.out.println("Beginning test of partial name (middle)...");
		List<Card> results = dao.searchInCollection("Bow of the", "Secret", "RIRA", prt);
		assertNotNull(results);
		System.out.println("Results:");
		for(Card result : results)
		{
			System.out.println(result.toString());
		}
		System.out.println("End of test.");
	}
}

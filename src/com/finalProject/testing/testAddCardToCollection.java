package com.finalProject.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.finalProject.dao.ygodbDAO;
import com.finalProject.entities.Card;
import com.finalProject.entities.MonsterCard;
import com.finalProject.entities.MonsterCard.Attribute;
import com.finalProject.entities.MonsterCard.Category;
import com.finalProject.entities.SpellCard;
import com.finalProject.entities.TrapCard;
//import com.finalProject.entities.Card.Condition;
//import com.finalProject.entities.Card.Printing;

public class testAddCardToCollection {

	private static Category cat;
	private static Attribute att;
	private static String prt;
	private ygodbDAO dao;
	
	@Before
	public void setUp() throws Exception {
		cat = Category.EFFECT;
		att = Attribute.EARTH;
		prt = "Unlimited";
		dao = new ygodbDAO();
	}

	@Test
	public void testAddOneCopy() {
		Card onecard = new MonsterCard("The Legendary Six Samurai - Kizan", "SPWA", "Monster", 1, "Super", prt, "Warrior", 1800, 300, 4, att, cat);
		System.out.println("Testing addition of one copy of a card...");
		boolean result = dao.addCardToCollection(onecard);
		assertEquals(result, true);
		System.out.println("End of test.");
	}
	
	@Test
	public void testAddMultipleCopies()
	{
		Card multicard = new MonsterCard("The Legendary Six Samurai - Kizan", "SPWA", "Monster", 5, "Super", prt, "Warrior", 1800, 300, 4, att, cat);
		System.out.println("Testing addition of multiple copies of a card...");
		boolean result = dao.addCardToCollection(multicard);
		assertEquals(result, true);
		System.out.println("End of test.");
	}
	
	@Test
	public void testAddZeroCopies()
	{
		Card multicard = new MonsterCard("The Legendary Six Samurai - Kizan", "SPWA", "Monster", 0, "Super", prt, "Warrior", 1800, 300, 4, att, cat);
		System.out.println("Testing addition of zero copies of a card...");
		boolean result = dao.addCardToCollection(multicard);
		assertEquals(result, false);
		System.out.println("End of test.");
	}
	
	@Test
	public void testAddNegativeCopies()
	{
		Card multicard = new MonsterCard("The Legendary Six Samurai - Kizan", "SPWA", "Monster", -1, "Super", prt, "Warrior", 1800, 300, 4, att, cat);
		System.out.println("Testing addition of negative copies of a card...");
		boolean result = dao.addCardToCollection(multicard);
		assertEquals(result, false);
		System.out.println("End of test.");
	}
	
	@Test
	public void testAddSpellCard()
	{
		Card spellcard = new SpellCard("Dark Ruler No More", "TN19", "Spell", 1, "LIMITED", "Prismatic Secret", SpellCard.Category.NORMAL);
		System.out.println("Testing addition of a Spell card...");
		boolean result = dao.addCardToCollection(spellcard);
		assertEquals(result, true);
		System.out.println("End of test.");
	}
	
	@Test
	public void testAddTrapCard()
	{
		Card trapcard = new TrapCard("There Can Be Only One", "DUDE", "Trap", 1, "LIMITED", "Ultra", TrapCard.Category.CONTINUOUS);
		System.out.println("Testing addition of a Trap card...");
		boolean result = dao.addCardToCollection(trapcard);
		assertEquals(result, true);
		System.out.println("End of test.");
	}
}

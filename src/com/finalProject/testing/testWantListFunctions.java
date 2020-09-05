package com.finalProject.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.finalProject.dao.ygodbDAO;
import com.finalProject.entities.Card;
import com.finalProject.entities.MonsterCard;
//import com.finalProject.entities.Card.Printing;
import com.finalProject.entities.MonsterCard.Attribute;
import com.finalProject.entities.MonsterCard.Category;
import com.finalProject.entities.WantListItem;

public class testWantListFunctions{

	private static Category cat;
	private static Attribute att;
	private static String prt;
	private static ygodbDAO dao;
	
	@BeforeClass
	public static void setUp() throws Exception {
		cat = Category.EFFECT;
		att = Attribute.EARTH;
		prt = "Unlimited";
		dao = new ygodbDAO();
	}

	@Test
	public void testAddToWantList() {
		Card onecard = new MonsterCard("The Legendary Six Samurai - Kageki", "SPWA", "Monster", 1, "Super", prt, "Warrior", 200, 2000, 3, att, cat);
		System.out.println("Testing addition of one copy of a card...");
		boolean result = dao.addCardToWantList(onecard);
		assertEquals(result, true);
		System.out.println("End of test.");
	}
	
	@Test
	public void testRemoveFromWantList() {
		Card onecard = new MonsterCard("The Legendary Six Samurai - Kizan", "SPWA", "Monster", 1, "Super", prt, "Warrior", 1800, 300, 4, att, cat);
		System.out.println("Testing removal of one copy of a card...");
		WantListItem result = dao.removeCardFromWantList(onecard);
		assertNotNull(result);
		System.out.println("End of test.");
	}
	
	@Test
	public void testGetAllCards() {
		List<WantListItem> wantList = dao.getWantList();
		for(WantListItem item : wantList)
		{
			System.out.println(item.toString());
		}
		assertNotNull(wantList);
	}
}

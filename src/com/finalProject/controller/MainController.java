package com.finalProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import com.finalProject.entities.Card;
import com.finalProject.entities.Deck;
import com.finalProject.entities.WantListItem;
import com.finalProject.services.ygodbServices;

@Controller
public class MainController {
	
	private static ygodbServices service = new ygodbServices();
	
	@RequestMapping(value = {"/", "/home"})
	public String homeHandler()
	{
		return "home";
	}
	
	//-----------------------------------------------------------------------------------------
	// ADD/REMOVE FROM COLLECTION FUNCTIONALITY
	//-----------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/add_cards", method = RequestMethod.GET)
	public ModelAndView showAddForm()
	{
		return new ModelAndView("add_cards", "card", new Card());
	}
	
	
	@RequestMapping(value = "/add_cards", method = RequestMethod.POST)
	public String submitAdd(@Valid @ModelAttribute("card")Card card,
			BindingResult result, ModelMap model)
	{
		if(result.hasErrors())
			return "add_remove_error";
		
		model.addAttribute("name", card.getName());
		model.addAttribute("setCode", card.getSetCode());
		model.addAttribute("rarity", card.getRarity());
		model.addAttribute("printing", card.getPrinting());
		
		service.addCardToCollection(card);
		
		return "add_cards";
	}
	
	@RequestMapping(value = "/remove_cards", method = RequestMethod.GET)
	public ModelAndView showRemoveForm()
	{
		return new ModelAndView("remove_cards", "card", new Card());
	}
	
	
	@RequestMapping(value = "/remove_cards", method = RequestMethod.POST)
	public String submitRemove(@Valid @ModelAttribute("card")Card card,
			BindingResult result, ModelMap model)
	{
		if(result.hasErrors())
			return "add_remove_error";
		
		model.addAttribute("name", card.getName());
		model.addAttribute("setCode", card.getSetCode());
		model.addAttribute("rarity", card.getRarity());
		model.addAttribute("printing", card.getPrinting());
		
		service.deleteCard(card);
		
		return "remove_cards";
	}

	//-----------------------------------------------------------------------------------------
	// SEARCH COLLECTION FUNCTIONALITY
	//-----------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/search_cards", method = RequestMethod.GET)
	public ModelAndView showSearchCollectionForm()
	{
		return new ModelAndView("search_cards", "card", new Card());
	}
	
	@RequestMapping(value = "/search_cards", method = RequestMethod.POST)
	public String executeSearch(@Valid @ModelAttribute("card")Card card,
			BindingResult result, ModelMap model,
			final RedirectAttributes redirectAttributes)
	{
		if(result.hasErrors())
			return "add_remove_error";
		
		model.addAttribute("name", card.getName());
		model.addAttribute("setCode", card.getSetCode());
		model.addAttribute("rarity", card.getRarity());
		model.addAttribute("printing", card.getPrinting());

		List<Card> search_results = service.searchInCollection(card.getName(), card.getRarity(), card.getSetCode(), card.getPrinting());
		
		redirectAttributes.addFlashAttribute("searchResults", search_results);
		
		return "redirect:/search_results";
	}
	
	@RequestMapping(value = "/search_results", method = RequestMethod.GET)
	public String searchResultsHandler(@ModelAttribute("searchResults") List<Card> searchResults, final RedirectAttributes redirectAttributes) 
	{
		return "search_results";
	}
	
	//-----------------------------------------------------------------------------------------
	// DECK MAINTENANCE FUNCTIONALITY
	//-----------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/deck_lists", method = RequestMethod.GET)
	public ModelAndView showDeckListSelectionForm() 
	{
		ModelAndView mav = new ModelAndView("deck_lists");
		return mav;
	}
	
	@RequestMapping(value = "/deck_lists", method = RequestMethod.POST)
	public String deckListHandler(@Valid @ModelAttribute("deck")Deck deck,
			BindingResult result, ModelMap model,
			final RedirectAttributes redirectAttributes)
	{
		model.addAttribute("name", deck.getName());
		model.addAttribute("allDecks", service.getAllDecks());
		Deck curDeck = service.getDeckByName(deck.getName());

		redirectAttributes.addFlashAttribute("curDeck", curDeck);
		
		return "redirect:/view_deck";
	}
	
	@RequestMapping("/new_deck")
	public String newDeckHandler() 
	{
		return "new_deck";
		//TODO: Implement
	}
	
	@RequestMapping(value = "/view_deck", method = RequestMethod.GET)
	public String viewDeckHandler() 
	{
		return "view_deck";
		//TODO: Implement
	}
	
	@RequestMapping("/add_to_deck")
	public String addToDeckHandler() 
	{
		return "add_to_deck";
		//TODO: Implement
	}
	
	//-----------------------------------------------------------------------------------------
	// WANT LIST MAINTENANCE FUNCTIONALITY
	//-----------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/want_list")
	public String wantListHandler(Model model) 
	{
		List<WantListItem> wantList = service.getWantList();
		
		model.addAttribute("wantList", wantList);
		
		return "want_list";
	}
	
	@RequestMapping(value = "/add_to_want_list", method = RequestMethod.GET)
	public ModelAndView showAddToWantListForm()
	{
		return new ModelAndView("add_to_want_list", "card", new Card());
	}
	
	@RequestMapping(value = "/add_to_want_list", method = RequestMethod.POST)
	public String addToWantListHandler(@Valid @ModelAttribute("card")Card card,
			BindingResult result, ModelMap model)
	{
		if(result.hasErrors())
			return "add_remove_error";
		
		model.addAttribute("name", card.getName());
		model.addAttribute("setCode", card.getSetCode());
		model.addAttribute("rarity", card.getRarity());
		model.addAttribute("printing", card.getPrinting());
		
		service.addCardToWantList(card);
		
		return "add_to_want_list";
	}
	
	@RequestMapping(value = "/remove_from_want_list", method = RequestMethod.GET)
	public ModelAndView showRemoveFromWantListForm()
	{
		return new ModelAndView("remove_from_want_list", "card", new Card());
	}
	
	@RequestMapping(value = "/remove_from_want_list", method = RequestMethod.POST)
	public String removeFromWantListHandler(@Valid @ModelAttribute("card")Card card,
			BindingResult result, ModelMap model)
	{
		if(result.hasErrors())
			return "add_remove_error";
		
		model.addAttribute("name", card.getName());
		model.addAttribute("setCode", card.getSetCode());
		model.addAttribute("rarity", card.getRarity());
		model.addAttribute("printing", card.getPrinting());
		
		service.removeCardFromWantList(card);
		
		return "remove_from_want_list";
	}
}

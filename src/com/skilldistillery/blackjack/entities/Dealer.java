package com.skilldistillery.blackjack.entities;

public class Dealer {
	private Deck deck = new Deck();

	public Dealer() {

	}

	public void checkDeck() {
		if (deck.checkDeckSize() < 10) {
			deck.makeDeck();
			deck.shuffleDeck(3);
		}
	}

	public void createNewDeck() {
		deck.makeDeck();
		deck.shuffleDeck(3);
	}
	public Card hit() {
		Card card = deck.dealCard();
		System.out.println(card);
		
		return card;
	}
	
	
	
	public Card dealCard() {
		Card card = deck.dealCard();
		
		return card;
	}

}

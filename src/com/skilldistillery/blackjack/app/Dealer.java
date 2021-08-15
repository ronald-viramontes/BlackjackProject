package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Deck;

public class Dealer extends Player {

	public Dealer() {

	}

	Deck deck = new Deck();

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

	public int dealFirstCard() {
		int total;
		total = deck.dealCard().getValue();
		return total;
	}

	public int dealSecondCard(int total) {
		int card = deck.dealCard().getValue();
		return total + card;
	}

	public int dealCard(int currentTotal) {
		int newCard = deck.dealCard().getValue();
		int total = currentTotal + newCard;
//		System.out.println("Card total: " + total);
		return total;
	}
}

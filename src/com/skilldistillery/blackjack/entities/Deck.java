package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;
	
	public Deck(List<Card> cardSet) {
		cardSet = deck;
	}
	
	public Deck() {
		
	}
	
	public List<Card> makeDeck() {
		deck = new ArrayList<>(52);
		for(Suit suit  : Suit.values()) {
			for(Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		} return deck;
		
		
	}
	public int checkDeckSize() {
		return deck.size();
	}
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffleDeck(int times) {
		for(int i = 0; i <= times; i++)
			Collections.shuffle(deck);
	}

	}
	
	
	


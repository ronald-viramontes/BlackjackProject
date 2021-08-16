package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Hand {
	private int handValue;
	private List<Card> hand;
	
	public Hand() {
		hand = new ArrayList<>();
	}
	
	public Hand(Deck hand) {
	
	}
	
	public void showHand() {
		for (Card card : hand) {
			System.out.println(card);
	}
	}
	
	
	public void addCard(Card card) {
		
		hand.add(card);
	}

	public void clear() {
		hand.removeAll(hand);
	}

	public int getHandValue() {
		handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		return handValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hand, handValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		return Objects.equals(hand, other.hand) && handValue == other.handValue;
	}

	@Override
	public String toString() {
		return "Hand [handValue=" + handValue + "]";
	}

}

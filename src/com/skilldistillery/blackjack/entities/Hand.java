package com.skilldistillery.blackjack.entities;

import java.util.Objects;

public abstract class Hand {
	private int handValue;

	public Hand(Deck hand) {
	
	}

	public void addCard(Card card) {

	}

	public void clear() {

	}

	public int getHandValue() {
		return handValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(handValue);
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
		return handValue == other.handValue;
	}

	@Override
	public String toString() {
		return "Hand [handValue=" + handValue + "]";
	}

}

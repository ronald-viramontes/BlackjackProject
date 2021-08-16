package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {
	private boolean isBlackjack;
	private boolean isBust;

	public BlackjackHand() {

	}

	public boolean isBlackjack(Hand hand) {
		if (hand.getHandValue() == 21) {
			isBlackjack = true;
		} else {
			isBlackjack = false;
		}

		return isBlackjack;
	}

	public boolean isBust(Hand hand) {
		if (hand.getHandValue() > 21) {
			isBust = true;
		} else {
			isBust = false;
		}
		return isBust;
	}
}

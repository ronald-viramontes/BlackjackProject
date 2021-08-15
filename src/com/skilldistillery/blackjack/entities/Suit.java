package com.skilldistillery.blackjack.entities;

public enum Suit {

	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	private String name;

	Suit(String nameMixedCase) {
		this.name = nameMixedCase;
	}

	@Override
	public String toString() {
		return this.name;
	}
}

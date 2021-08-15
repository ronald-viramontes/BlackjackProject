package com.skilldistillery.blackjack.app;

import java.util.Objects;

import com.skilldistillery.blackjack.entities.Card;

public abstract class Player {
		
		private boolean hitting;
		private boolean standing;
		private boolean playing;
		private String name;
	
		
		
	public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	public Player(){
		
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public boolean playAgain(boolean playAgain) {
		if(!playAgain) {
			
		}
		return playAgain;
	}
	
	
	public boolean playing(boolean playing) {
		
		if (!playing) {
			
		}
		return playing;
	}
	
	public boolean hit(Card card, boolean hitting) {
		
		if(!hitting) {
			//give card to player
		}
		return hitting;
	}
	
	public boolean stand(boolean standing) {
		
		if(!standing) {
			//proceed to next player
		}
			return standing;
		
	}
	public void gamePlayerWins() {
		System.out.println(name + " Wins!");
	}
	public void dealerWins() {
		System.out.println("Dealer wins!");
	}
	public void playersTie() {
		System.out.println("Player has tied with the dealer!");
	}
	
	@Override
	public String toString() {
		return "Player [hitting=" + hitting + ", standing=" + standing + ", playing=" + playing + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hitting, playing, standing);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return hitting == other.hitting && playing == other.playing && standing == other.standing;
	}

	public boolean isHitting() {
		return hitting;
	}

	public void setHitting(boolean hitting) {
		this.hitting = hitting;
	}

	public boolean isStanding() {
		return standing;
	}

	public void setStanding(boolean standing) {
		this.standing = standing;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	
	
	
	
}

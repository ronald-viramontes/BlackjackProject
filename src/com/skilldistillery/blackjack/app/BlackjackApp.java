package com.skilldistillery.blackjack.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;
import com.skilldistillery.blackjack.entities.SoundBytePlayer;
import com.skilldistillery.blackjack.entities.newPlayer;

public class BlackjackApp {
	SoundBytePlayer sound = new SoundBytePlayer();
	List<Card> playerHandList = new ArrayList<>();
	List<Card> dealerHandList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		BlackjackApp app = new BlackjackApp();

		String name = app.gameLaunch(kb);

		app.run(kb, name);
	}

	public String gameLaunch(Scanner kb) {
		printSomeFile("blackjack.txt");
		sound.play("casino.wav");
		System.out.println("\n\nEnter your name: ");
		String name = kb.nextLine();
		return name;

	}

	public void run(Scanner kb, String name) {
		System.out.println("\n\n\tGame starting...");

		Player player = new newPlayer(name);
		Dealer dealer = new Dealer();
		dealer.createNewDeck();

		String playerChoice = "";

		String userSelection = "";

		Hand playerHand = new BlackjackHand();
		Hand dealerHand = new BlackjackHand();

		do {

			playerHand.addCard(dealer.dealCard());

			dealerHand.addCard(dealer.dealCard());

			playerHand.addCard(dealer.dealCard());

			dealerHand.addCard(dealer.dealCard());

			System.out.println("Dealer Hand: ");
			dealerHand.showHand();
			System.out.println("Hand value: " + dealerHand.getHandValue());

			System.out.println();

			System.out.println(player.getName() + "'s hand: ");
			playerHand.showHand();
			int playerTotal = playerHand.getHandValue();
			System.out.println("Hand value: " + playerTotal);
			System.out.println();

			if (playerTotal < 21) {
				while (playerHand.getHandValue() < 21) {
					System.out.println(player.getName() + " Select -->    " + "1. Hit   or   2. Stand");
					playerChoice = kb.nextLine();
					if (playerChoice.equals("2")) {
						System.out.println(player.getName() + " stands!");
						break;
					}
					if (playerChoice.equals("1")) {
						playerHand.addCard(dealer.hit());
						System.out.println(player.getName() + "'s " + playerHand.getHandValue());
					}
					if (playerHand.getHandValue() == 21) {
						System.out.println("Player has 21!");
						break;
					}
					if (playerHand.getHandValue() > 21) {
						System.out.println("Busted");
						System.out.println("Player: " + player.getName() + " loses!");
						break;
					}
				}
			} else if (playerHand.getHandValue() == 21) {
				System.out.println(player.getName() + "'s" + " has 21!");
			}

			if (dealerHand.getHandValue() < 17) {
				dealerHand(dealer, dealerHand);
			}

			compareHands(playerHand, dealerHand, player);

			System.out.println("\nPlay again?  1. Yes    2. No");
			userSelection = kb.nextLine();

			if (userSelection.equals("1")) {
				System.out.println();
				dealer.checkDeck();
				dealerHand.clear();
				playerHand.clear();
			}
			if (userSelection.equals("2")) {

				System.out.println();

				System.out.println("Thank you for playing...Goodbye!");
				printSomeFile("blackjack.txt");
				kb.close();
				System.exit(0);
			}

		} while (userSelection.equals("1"));

	}

	public void compareHands(Hand playerHand, Hand dealerHand, Player player) {
		
		System.out.println("Dealer total: " + dealerHand.getHandValue());

		System.out.println();

		System.out.println(player.getName() + "'s total " + playerHand.getHandValue());
		

		if (dealerHand.getHandValue() <= 21 && playerHand.getHandValue() > 21) {
			printSomeFile("youlose.txt");
			System.out.println("Dealer Wins!");
		}
		if (dealerHand.getHandValue() > 21 && playerHand.getHandValue() <= 21) {
			printSomeFile("youwin.txt");
			System.out.println("You win!");
		}
		if (playerHand.getHandValue() <= 21 && dealerHand.getHandValue() <= 21) {
			if (playerHand.getHandValue() > dealerHand.getHandValue()) {
				printSomeFile("youwin.txt");
			} else if (playerHand.getHandValue() == dealerHand.getHandValue()) {
				printSomeFile("tiegame.txt");
			} else {
				printSomeFile("youlose.txt");
			}
		}

	}

	public int dealerHand(Dealer dealer, Hand dealerHand) {
		System.out.println("Dealer Hand: ");
		dealerHand.showHand();
		while (dealerHand.getHandValue() < 17) {
			dealerHand.addCard(dealer.hit());
			System.out.println("Hand total: " + dealerHand.getHandValue());
			if (dealerHand.getHandValue() > 21) {
				System.out.println("Dealer Busted");
				break;
			}
		}
		if (dealerHand.getHandValue() == 21) {
			System.out.println("Dealer has Blackjack!");
		}
		System.out.println("Dealer total: " + dealerHand.getHandValue());
		return dealerHand.getHandValue();
	}

	public void printSomeFile(String fileName) {
		String line = null;
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}
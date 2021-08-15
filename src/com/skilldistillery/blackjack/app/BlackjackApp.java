package com.skilldistillery.blackjack.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.SoundBytePlayer;

public class BlackjackApp {
	SoundBytePlayer sound = new SoundBytePlayer();

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		BlackjackApp app = new BlackjackApp();
		app.gameLaunch(kb);

	}

	public void gameLaunch(Scanner kb) {
		printSomeFile("blackjack.txt");
		sound.play("casino.wav");
		run(kb);

	}

	public void run(Scanner kb) {
		System.out.println("\n\nEnter your name: ");
		String name = kb.nextLine();
		Player player = new GamePlayer(name);
		Dealer dealer = new Dealer();
		dealer.createNewDeck();

		System.out.println("\n\n\tGame starting...");

		String playerChoice = "";
		boolean done = false;
		int playerTotal = 0;
		int dealerTotal = 0;
		String userSelection = "";

		do {
			playerTotal = dealer.dealFirstCard();
			dealerTotal = dealer.dealFirstCard();
			System.out.println(player.getName() + "'s" + " 1st Card: " + playerTotal + "\tDealer's " + " 1st Card: "
					+ dealerTotal);
			System.out.println();

			playerTotal = dealer.dealSecondCard(playerTotal);
			dealerTotal = dealer.dealSecondCard(dealerTotal);

			System.out.println(player.getName() + "'s" + " total is: " + playerTotal + "\tDealer's " + " total is: "
					+ dealerTotal);
			System.out.println();

			while (playerTotal < 21) {

				System.out.println(player.getName() + " Select -->    " + "1. Hit   or   2. Stand");
				playerChoice = kb.nextLine();
				if (playerChoice.equals("2")) {
					System.out.println(player.getName() + " stands!");
					break;
				}
				if (playerChoice.equals("1")) {
					playerTotal = dealer.dealCard(playerTotal);
					System.out.println(player.getName() + "'s " + " Hand total " + "is: " + playerTotal);
					if (playerTotal == 21) {
						System.out.println(player.getName() + "'s" + " has 21!");
						break;
					}
					if (playerTotal > 21) {
						System.out.println("Busted");
						System.out.println("Player: " + player.getName() + " loses!");
						break;
					}
				}
			}

			if (playerTotal == 21) {
				System.out.println(player.getName() + "'s" + " has 21!");
			}

			dealerHand(dealer, dealerTotal);
			compareHands(playerTotal, dealerTotal, player);

			System.out.println("\nPlay again?  1. Yes    2. No");
			userSelection = kb.nextLine();

			if (userSelection.equals("1")) {
				System.out.println();
				dealer.checkDeck();
				dealerTotal = 0;
				playerTotal = 0;
			}
			if (userSelection.equals("2")) {

				System.out.println();
				System.out.println("Thank you for playing...Goodbye!");
				printSomeFile("blackjack.txt");
				System.exit(0);
			}
		} while (!done);
	}

	public void compareHands(int playerTotal, int dealerTotal, Player player) {
		if (playerTotal > 21 && dealerTotal <= 21) {
			printSomeFile("youlose.txt");
			System.out.println("Dealer Wins!");
		} else if (playerTotal > 21 && dealerTotal > 21) {
			printSomeFile("bothlose.txt");
			System.out.println("Dealer & Player Lose!");
		} else if (playerTotal <= 21 && dealerTotal <= 21 && playerTotal > dealerTotal) {
			printSomeFile("youwin.txt");
			System.out.println(player.getName() + " Wins!");
		} else if (playerTotal <= 21 && dealerTotal <= 21 && playerTotal == dealerTotal) {
			printSomeFile("tiegame.txt");
			System.out.println("Tie Game!");
		} else if (playerTotal <= 21 && dealerTotal <= 21 && playerTotal < dealerTotal) {
			printSomeFile("youlose.txt");
			System.out.println("Dealer Wins!");
		}
	}

	public int dealerHand(Dealer dealer, int dealerTotal) {
		if (dealerTotal == 21) {
			System.out.println("Dealer has Blackjack!");
		}
		while (dealerTotal < 17) {
			dealerTotal = dealer.dealCard(dealerTotal);
		}
		if (dealerTotal > 21) {
			System.out.println("Dealer Busted");
		}

		System.out.println("Dealer total: " + dealerTotal);
		return dealerTotal;
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
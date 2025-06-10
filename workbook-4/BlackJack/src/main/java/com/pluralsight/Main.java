package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        System.out.print("Enter number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());

        String[] playerNames = new String[numPlayers];
        Hand[] hands = new Hand[numPlayers];

        // Get player names and create hands
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            playerNames[i] = scanner.nextLine();
            hands[i] = new Hand();
        }

        // Deal 2 cards to each player
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numPlayers; j++) {
                Card card = deck.deal();
                hands[j].deal(card);
            }
        }

        // Show hands and calculate scores
        int highestScore = 0;
        int winnerIndex = -1;

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("\n" + playerNames[i] + "'s hand:");
            hands[i].print();
            int score = hands[i].getValue();
            System.out.println("Score: " + score);

            if (score <= 21 && score > highestScore) {
                highestScore = score;
                winnerIndex = i;
            }
        }

        // Announce winner
        if (winnerIndex != -1) {
            System.out.println("\n Winner: " + playerNames[winnerIndex] +
                    " with a score of " + highestScore + "!");
        } else {
            System.out.println("\nNo winner! Everyone busted.");
        }

        scanner.close();
    }
}

package com.example.jokenpo;

import java.io.PrintStream;
import java.util.Scanner;

public class JokenpoApp {
	private Scanner inputScanner;
	private PrintStream output;
	private Player playerOne;
	private Player playerTwo;
	private int matches;
	private int ties;
	private enum Choice {
		PEDRA, PAPEL, TESOURA;

		/**
		 * Compare choices e return Tie or Winner.
		 * @param otherChoice choice to compare
		 * @return 1 if current choice wins, 2 if current choice loses and 0 in case of tie
		 */
		public int compareChoices(Choice otherChoice) {
			// Tie
			if (this == otherChoice)
				return 0;

			// Using switch to decide who's the winner
			switch (this) {
				case PEDRA:
					return (otherChoice == TESOURA ? 1 : 2);
				case PAPEL:
					return (otherChoice == PEDRA ? 1 : 2);
				case TESOURA:
					return (otherChoice == PAPEL ? 1 : 2);
			}

			return 0; // If code reaches this point, it's a tie
		} // Close compareChoices function
	} // Close enum Choice


	/**
	 * JokenpoApp Constructor
	 * @param userInput Scanner containing where to fetch data. Usually from System.in
	 * @param systemOutput PrintStream containing where to send system outputs. Usually System.out
	 */
	public JokenpoApp(Scanner userInput, PrintStream systemOutput) {
		this.inputScanner = userInput;
		this.output = systemOutput;
		this.playerOne = new Player();
		this.playerTwo = new Player();
		this.matches = 0;
	} // Close JokenpoApp constructor

	private class Player {
		private int score;
 
		/**
		 * Player Constructor
		 */
        public Player() {
			this.score = 0;
		} // Close Player constructor


		/**
		 * Ask user choice and return
		 * @return One of enum Choice possible values
		 */
        public Choice getChoice() {
			// Ask player choice
			output.println("Escolha entre pedra, papel ou tesoura.");
		 
			// Get player answer
			String playerInput = inputScanner.nextLine().toUpperCase();

			// Try to convert player answer to Enum or throw Exception and ask player input again
			try {
				return Choice.valueOf(playerInput);
			} catch (IllegalArgumentException exc) {
				output.print("Escolha inválida, tente novamente. ");
				return getChoice();
			}
		} // Close getChoice function


		/**
		 * Ask user if he wants to play again
		 * @return boolean containing user asnwer
		 */
        public boolean wantToStartOver() {
			output.print("Jogar novamente? [S/N] ");
			try {
				String userInput = inputScanner.nextLine().toUpperCase();
				return userInput.charAt(0) == 'S';
			} catch (StringIndexOutOfBoundsException exc) {
				output.println("Escolha inválida, tente novamente. ");
				return wantToStartOver();
			}
        } // Close wantToStartOver function


		/**
		 * Increase current user score. Function used just for code readability
		 */
		public void increaseScore() {
			this.score++;
		} // Close increaseScore function
	} // Close Player class


	/**
	 * Starts the game, get players answers, announces game results
	 */
	public void startGame() {
        output.println("PEDRA, PAPEL, TESOURA!");
 
        // Get player One choice
        Choice playerOneChoice = playerOne.getChoice();
		output.printf("Jogador um escolheu %s.%n", playerOneChoice);
		
        // Get player Two choice
        Choice playerTwoChoice = playerTwo.getChoice();
        output.printf("Jogador dois escolheu %s.%n", playerTwoChoice);
 
        // Compare choices and announce winner
        int compareChoices = playerOneChoice.compareChoices(playerTwoChoice);
        switch (compareChoices) {
		case 0: // Tie
			ties++;
            output.println("Empate!");
            break;
        case 1: // Player One Wins
			playerOne.increaseScore();
            output.printf("%s ganha de %s. Jogador um vence!%n", playerOneChoice, playerTwoChoice);
            break;
		case 2: // Player Two Wins
			playerTwo.increaseScore();
            output.printf("%s ganha de %s. Jogador dois vence!%n", playerTwoChoice, playerOneChoice);
            break;
        }
        matches++;
 
        // Ask user if he wants to play again
        if (playerOne.wantToStartOver()) {
            startGame();
        } else {
            showResults();
        }
	} // Close startGame function


	/**
	 * Show match final result
	 */
	private void showResults() {
		output.printf(
			"%nVitórias Jogador um: %d | Vitórias Jogador dois: %d | Empates: %d | Partidas: %d%n",
			playerOne.score, playerTwo.score, ties, matches);
	} // Close showResults 



	public static void main(String[] args) {
		JokenpoApp game = new JokenpoApp(new Scanner(System.in), System.out);
        game.startGame();
	} // Close main function
}

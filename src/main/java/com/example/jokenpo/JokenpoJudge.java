package com.example.jokenpo;

public class JokenpoJudge {
	private Choice playerOneChoice;
	private Choice playerTwoChoice;

	static enum Choice {
		PEDRA, PAPEL, TESOURA;
	} // Close enum Choice


	/**
	 * JokenpoJudge Constructor
	 * @param playerOne String containing player one Choice
	 * @param playerTwo String containing player two Choice
	 * @exception IllegalArgumentException In case the String input can't be converted to enum Choice
	 */
	public JokenpoJudge(String playerOne, String playerTwo) {
		try {
			this.playerOneChoice = Choice.valueOf(playerOne.toUpperCase());
			this.playerTwoChoice = Choice.valueOf(playerTwo.toUpperCase());
		} catch (IllegalArgumentException exc) {
			throw new IllegalArgumentException(String.format(
				"%s informou uma escolha inválida, tente novamente.",
				(this.playerOneChoice == null ? "Jogador um" : "Jogador dois")
			));
		}
	} // Close JokenpoApp constructor

	/**
	 * Compare choices e return Tie or Winner.
	 * @param otherChoice choice to compare
	 * @return 1 if player one wins, 2 if player two wins and 0 in case of tie
	 */
	public int getResult() {
		// Tie
		if (playerOneChoice == playerTwoChoice)
			return 0;

		// Using switch to decide who's the winner
		switch (playerOneChoice) {
			case PEDRA:
				return (playerTwoChoice == Choice.TESOURA ? 1 : 2);
			case PAPEL:
				return (playerTwoChoice == Choice.PEDRA ? 1 : 2);
			case TESOURA:
				return (playerTwoChoice == Choice.PAPEL ? 1 : 2);
		}
		return 0; // If code reaches this point, it's a tie
	} // Close compareChoices function

	public static void main(String[] args) {
		JokenpoJudge judge = new JokenpoJudge(args[0], args[1]);
		System.out.println(judge.getResult());
	} // Close main function
}

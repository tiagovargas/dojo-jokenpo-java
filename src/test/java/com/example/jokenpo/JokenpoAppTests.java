package com.example.jokenpo;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JokenpoAppTests {
	JokenpoApp jokenpoMatch;
	ByteArrayOutputStream byteArrayOutput;

	@Before
	public void setup(){
		//This var will store the program output
		this.byteArrayOutput = new ByteArrayOutputStream();
	}
	
	@Test
	public void TestProgramOutputs() {
		String input = "pedra\n"	// playerOne input
					 + "spock\n"	// playerTwo input with error, asks user input again
					 + "tesoura\n"	// playerTwo input
					 + "N\n";		// user don't want to play again
		this.jokenpoMatch = new JokenpoApp(new Scanner(input), new PrintStream(byteArrayOutput, true, StandardCharsets.UTF_8));
		jokenpoMatch.startGame();
		// assertEquals(1, jokenpoMatch.startGame());
		Scanner output = new Scanner(new String(byteArrayOutput.toByteArray(), StandardCharsets.UTF_8));

		String pedraPapelTesoura = output.nextLine();
		assertEquals(pedraPapelTesoura, "PEDRA, PAPEL, TESOURA!");

		String escolhaPedraPapelTesoura1 = output.nextLine();
		assertEquals(escolhaPedraPapelTesoura1, "Escolha entre pedra, papel ou tesoura.");

		String escolhaJogadorUm = output.nextLine();
		assertEquals(escolhaJogadorUm, "Jogador um escolheu PEDRA.");
		
		String escolhaPedraPapelTesoura2 = output.nextLine();
		assertEquals(escolhaPedraPapelTesoura2, "Escolha entre pedra, papel ou tesoura.");
		
		String escolhaErradaJogadorDois = output.nextLine();
		assertEquals(escolhaErradaJogadorDois, "Escolha inválida, tente novamente. Escolha entre pedra, papel ou tesoura.");

		String escolhaJogadorDois = output.nextLine();
		assertEquals(escolhaJogadorDois, "Jogador dois escolheu TESOURA.");

		String vencedor = output.nextLine();
		assertEquals(vencedor, "PEDRA ganha de TESOURA. Jogador um vence!");

		String jogarNovamente = output.nextLine();
		assertEquals(jogarNovamente, "Jogar novamente? [S/N] ");

		String resultadoFinal = output.nextLine();
		assertEquals(resultadoFinal, "Vitórias Jogador um: 1 | Vitórias Jogador dois: 0 | Empates: 0 | Partidas: 1");

		output.close();
	}

}

package com.example.jokenpo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JokenpoJudgeTests {
	JokenpoJudge judge;

	@Test
	public void playerOneWinsWithRock() {
		this.judge = new JokenpoJudge("pedra", "tesoura");
		assertEquals(1, this.judge.getResult());
	}

	@Test
	public void playerOneWinsWithPaper() {
		this.judge = new JokenpoJudge("papel", "pedra");
		assertEquals(1, this.judge.getResult());
	}

	@Test
	public void playerOneWinsWithScissors() {
		this.judge = new JokenpoJudge("tesoura", "papel");
		assertEquals(1, this.judge.getResult());
	}

	@Test
	public void playerTwoWinsWithRock() {
		this.judge = new JokenpoJudge("tesoura", "pedra");
		assertEquals(2, this.judge.getResult());
	}

	@Test
	public void playerTwoWinsWithPaper() {
		this.judge = new JokenpoJudge("pedra", "papel");
		assertEquals(2, this.judge.getResult());
	}

	@Test
	public void playerTwoWinsWithScissors() {
		this.judge = new JokenpoJudge("papel", "tesoura");
		assertEquals(2, this.judge.getResult());
	}

	@Test
	public void tieWithRock() {
		this.judge = new JokenpoJudge("pedra", "pedra");
		assertEquals(0, this.judge.getResult());
	}

	@Test
	public void tieWithPaper() {
		this.judge = new JokenpoJudge("papel", "papel");
		assertEquals(0, this.judge.getResult());
	}

	@Test
	public void tieWithScissors() {
		this.judge = new JokenpoJudge("tesoura", "tesoura");
		assertEquals(0, this.judge.getResult());
	}

}

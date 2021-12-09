package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;

import roulette.Bet;

/**
 * Minimally tests the Bet class.
 * 
 * @author Robert C. Duvall
 */
public class BetTest {

	private Bet b;

	@BeforeEach
	void setUp() throws Exception {
		b = new Bet("Bet", 13);
	}

	@Test
	public void testCreation() {
		assertEquals("Bet", b.getDescription());
		assertEquals(13, b.getPayout());
	}

	@Test
	public void testCreation() {
		assertEquals("Bet", b.getDescription());
		assertEquals(13, b.getPayout());
	}
}

package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import roulette.Gambler;

/**
 * Test the Gambler class.
 * 
 * @author Robert C. Duvall
 */
public class GamblerTest {

	@Test
	public void testCreation() {
		Gambler g = new Gambler("Robert", 1001);
		assertEquals(g.getName(), "Robert");
		assertEquals("Robert", g.getName());
		assertEquals(1001, g.getBankroll());
	}

	@Test
	public void testSolvent() {
		Gambler g;

		g = new Gambler("Robert", 0);
		assertTrue(!g.isSolvent());

		g = new Gambler("Robert", -1);
		assertTrue(!g.isSolvent());

		g = new Gambler("Robert", 1);
		assertTrue(g.isSolvent());
	}

	@Test
	public void testUpdate() {
		Gambler g = new Gambler("Robert", 1);

		g.updateBankroll(0);
		assertEquals(1, g.getBankroll());
		g.updateBankroll(-1);
		assertEquals(0, g.getBankroll());
		g.updateBankroll(2);
		assertEquals(2, g.getBankroll());
		g.updateBankroll(13);
		assertEquals(15, g.getBankroll());
	}

}

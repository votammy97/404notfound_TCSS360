/*
 * TCSS 360 - Spring 2019
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.StringFormatters;

/**
 * Tests model.StringFormatters;
 * 
 * @author Gordon McCreary
 * @version May 30, 2019
 */
class StringFormattersTest {
	
	// Tests StringFormatters.removeNonInt(String theInput);
	@Test
	public void testRemoveNonInt0() {
		assertEquals("", StringFormatters.removeNonInt(""));
	}
	@Test
	public void testRemoveNonInt1() {
		assertEquals("0", StringFormatters.removeNonInt("0"));
	}
	@Test
	public void testRemoveNonInt2() {
		assertEquals("9", StringFormatters.removeNonInt("9"));
	}
	@Test
	public void testRemoveNonInt3() {
		assertEquals("", StringFormatters.removeNonInt("a"));
	}
	@Test
	public void testRemoveNonInt4() {
		assertEquals("15", StringFormatters.removeNonInt("-1oo5"));
	}
	
	
	
	// Tests StringFormatters.formatCost(String theInput);
	@Test
	public void testFormatCost0() {
		assertEquals("$", StringFormatters.formatCost(""));
	}
	@Test
	public void testFormatCost1() {
		assertEquals("$1", StringFormatters.formatCost("1"));
	}
	@Test
	public void testFormatCost2() {
		assertEquals("$1.00", StringFormatters.formatCost("1.0"));
	}
	@Test
	public void testFormatCost3() {
		assertEquals("$1", StringFormatters.formatCost("$1"));
	}
	@Test
	public void testFormatCost4() {
		assertEquals("$1.00", StringFormatters.formatCost("$1.0"));
	}
	@Test
	public void testFormatCost5() {
		assertEquals("$1.15", StringFormatters.formatCost("af1.$159.0"));
	}
	
	
	
	// Tests StringFormatters.formatLength(String theInput, int theLength);
	@Test
	public void testFormatLength0() {
		assertEquals("", StringFormatters.formatLength("", 10));
	}
	
	// Tests StringFormatters.formatLength(String theInput, int theLength);
	@Test
	public void testFormatLength1() {
		assertEquals("", StringFormatters.formatLength("", 0));
	}

}

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.DIYFileManager;
import view.Login;

class LoginTest {

	private Login a = new Login();
	private DIYFileManager mng = new DIYFileManager();
	@Test
	void testSetNameString() {
		String name = "testName";
		a.setName(name);
		assertEquals(name, a.getName());
	}

	@Test
	void testSetEmail() {
		String email = "fhiwehf@guh.eiwfhiew";
		a.setEmail(email);
		assertEquals(email, a.getEmail());
		
	}

	@Test
	void testGetName() {
		a.setName("1313");
		assertEquals("1313", a.getName());
	}

	@Test
	void testGetEmail() {
		a.setEmail("123@13.123");
		assertEquals("123@13.123", a.getEmail());
	}
	
	@Test
	void testsetInfo() {
		a.setEmail("123@13.123");
		a.setName("1313");
		a.setInfo(mng);
		assertEquals("123@13.123", mng.getEmail());
		assertEquals("1313", mng.getName());
	}
}

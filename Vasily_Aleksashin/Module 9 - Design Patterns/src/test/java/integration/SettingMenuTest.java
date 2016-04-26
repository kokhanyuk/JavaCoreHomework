package integration;

import controller.Main;
import org.junit.Test;
import view.impl.ConsoleMock;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class SettingMenuTest {
	private static final String SEPARATOR = "=========================================\n";
	private static final String SEPARATOR_BACK = "=========================================\r\n";
	private static final String MAIN_MENU = SEPARATOR +
			"\tMAIN MENU\n" +
			SEPARATOR +
			"[0] Application configuring\n" +
			"[1] Load user profile\n" +
			"[2] Show DataStore\n" +
			"[3] Exit\n" +
			SEPARATOR_BACK;
	private static final String CONF_MENU = SEPARATOR +
			"\tApplication configuring Menu\n" +
			SEPARATOR +
			"[0] Set XML parser\n" +
			"[1] Set DataStore\n" +
			"[2] Back to Main Menu\n" +
			SEPARATOR_BACK;
	private static final String SET_PARSER = "Select parser method:\n" +
			"[0] - DOM\n" +
			"[1] - SAX\n" +
			"[2] - StAX\r\n";
	private static final String SET_DATA_STORE = "Select type of DataStore:\n" +
			"[0] - List DataStore\n" +
			"[1] - Set DataStore\r\n";
	private static final String THANK_YOU_FOR_USING_MY_APP = "Thank you for using my App\r\n";

	private final ConsoleMock console = new ConsoleMock();

	@Test
	public void testSetParser() throws UnsupportedEncodingException {
		console.addIn("0");
		console.addIn("0");
		console.addIn("1");
		console.addIn("2");
		console.addIn("3");

		Main.main(new String[0]);

		final String expected = MAIN_MENU + CONF_MENU + SET_PARSER + CONF_MENU + MAIN_MENU + THANK_YOU_FOR_USING_MY_APP;
		assertEquals(expected, console.getOut());
	}

	@Test
	public void testSetDataStore() throws UnsupportedEncodingException {
		console.addIn("0");
		console.addIn("1");
		console.addIn("0");
		console.addIn("2");
		console.addIn("3");

		Main.main(new String[0]);

		final String expected = MAIN_MENU + CONF_MENU + SET_DATA_STORE + CONF_MENU + MAIN_MENU + THANK_YOU_FOR_USING_MY_APP;
		assertEquals(expected, console.getOut());
	}
}

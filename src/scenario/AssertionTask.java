package scenario;

import org.testng.asserts.SoftAssert;

public class AssertionTask {


	public static void verifyText(String actual, String expected) {
		try {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actual, expected);
			softAssert.assertAll();
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}

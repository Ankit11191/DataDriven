package amazon;

import org.testng.annotations.*;

import scenario.*;

/**
 * @author Ankit.Mittal
 *
 */
public class demologin {
	@BeforeSuite
	public void openbroser() throws Exception 
	{
		BrowserSet.SelectBrowser();
	}

	@Test
	public void testcase() throws Exception {
		SetMethod.click(ReadProerties
				.propsObjectsSplit("seleniumpoint_test_website"));
		SetMethod.sendkey(
				ReadProerties.propsObjectsSplit("seleniumpoint_uidloc"),"seleniumpoint_Email");
		SetMethod.sendkey(
				ReadProerties.propsObjectsSplit("seleniumpoint_passwordloc"),"seleniumpoint_pwd");
		SetMethod
				.click(ReadProerties.propsObjectsSplit("seleniumpoint_submit"));
		wait_time.sleep("5");

	}
	 @AfterSuite
	 public void closeBrowser() throws Exception 
	 {
	 BrowserSet.drivreturn().quit();
	 }
}

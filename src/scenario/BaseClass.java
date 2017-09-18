package scenario;

import org.testng.annotations.*;

public class BaseClass 
{
//	@BeforeSuite
//	@BeforeGroups
//	@BeforeClass
//	@BeforeMethod
	@BeforeTest
	public static void OpenBrowser()
	{
		BrowserSet.SelectBrowser();
	}
//	@AfterSuite
//	@AfterGroups
//	@AfterClass
//	@AfterMethod
	@AfterTest
	public static void closeBrowser()
	{
		BrowserSet.drivreturn().quit();
	}
}

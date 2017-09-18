package scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserSet 
{
	static WebDriver driver;
	static String URL;

	public static WebDriver SelectBrowser()
	{
		String[] browsername;
		try {
			browsername = ReadProerties.propsObjectsSplit("browserName");
		if(browsername[0].equalsIgnoreCase("Chrome"))
		{
			ChromeOptions chromeOptions=new ChromeOptions();
			//to disable notifications and maximize window
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("start-maximized");
			
			DesiredCapabilities capabilities=DesiredCapabilities.chrome();
			//To clear cache
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			//To marge capabilities and options in one unit so same can be define while calling browser
			capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
			
			System.setProperty("webdriver.chrome.driver", "C:/External_jars/chromedriver.exe");
			driver=new ChromeDriver(capabilities);
		}
		if(browsername[0].equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		if(browsername[0].equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		
		if(browsername[0].equalsIgnoreCase("ChromeHeadLess"))
		{
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--headless");

			System.setProperty("webdriver.chrome.driver", "C:/External_jars/chromedriver.exe");
			driver=new ChromeDriver(chromeOptions);
		}

		
		driver.manage().window().maximize();
		String[] url=ReadProerties.propsObjectsSplit("AppURL");
		driver.get(url[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	public static WebDriver drivreturn()
	{
		WebDriver retrn = driver;
		return retrn;
	}
}

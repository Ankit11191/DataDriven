package scenario;

import org.openqa.selenium.WebDriver;

public class windowhandler 
{
	public static void tabhandler() throws Exception
	{
		WebDriver driver = BrowserSet.drivreturn();
		for(String childtab:driver.getWindowHandles())
		{
			driver.switchTo().window(childtab);
		}
			
	}
	
}

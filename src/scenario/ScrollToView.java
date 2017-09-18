package scenario;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollToView 
{
	public static void Scrolling(String[] sElement) throws Exception
	{
		WebDriver driver = BrowserSet.drivreturn();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",SetMethod.select(sElement));
	}
}

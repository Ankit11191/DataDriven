package scenario;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutor 
{
	JavaScriptExecutor(String Commmand){
	try {
			WebDriver driver = BrowserSet.drivreturn();
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript(Commmand);
		}
	catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}

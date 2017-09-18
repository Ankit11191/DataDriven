package scenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait_time {

	public static void ImplisitWait(String time) throws Exception
	{
		int timing=Integer.parseInt(time);
		WebDriver driver = BrowserSet.drivreturn();
		driver.manage().timeouts().implicitlyWait(timing, TimeUnit.SECONDS);	
	}

	public static void sleep(String time) throws Exception
	{
		int timing=Integer.parseInt(time);
		timing=timing*1000;
		Thread.sleep(timing);//in seconds
	}
	
	public static void explicit(String time) throws Exception
	{
		int timing=Integer.parseInt(time);
		WebDriver driver = BrowserSet.drivreturn();
		new WebDriverWait(driver, timing);
	}
}

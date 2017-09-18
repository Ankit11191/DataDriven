package scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.*;
import org.testng.annotations.Test;

public class Sikuli {

	
	@Test(priority=1)
	public  void skuli() throws FindFailed 
	{
		Screen screen= new Screen();
		Pattern ptrn1=new Pattern("C:\\Users\\ankit.mittal\\Desktop\\sikuli\\sikuli1.png");
		
		System.setProperty("webdriver.chrome.driver", "C:/External_jars/chromedriver.exe");
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.get("https://www.google.co.in/");
		
		screen.wait(ptrn1,5000);
		screen.click(ptrn1);
		
		driv.quit();
	}
	
	@Test(priority=0)
	public void Scrolling()
	{
	System.out.println("test1");
	}

}
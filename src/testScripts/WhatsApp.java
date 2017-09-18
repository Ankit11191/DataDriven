package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import scenario.ScreenShot;

public class WhatsApp 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:/External_jars/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://web.whatsapp.com/");
		Thread.sleep(60000);
		driver.findElement(By.className("input-search")).sendKeys("neha");
		Thread.sleep(3000);
		driver.findElement(By.className("matched-text")).click();
		driver.findElement(By.className("input")).sendKeys("hi");
		ScreenShot.takesanp();
		driver.quit();
	}

}

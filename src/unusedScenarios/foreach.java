package unusedScenarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import scenario.BrowserSet;

public class foreach
{
	public static String date(int days) throws Exception 
	{
		DateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
		Calendar calendar=Calendar.getInstance();
		
		calendar.add(Calendar.DATE, days);
		String date=dateFormat.format(calendar.getTime());
		return date;
	}
	
	public static void main(String[] args) throws Exception {

		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("start-maximized");

		System.setProperty("webdriver.chrome.driver", "C:/External_jars/chromedriver.exe");
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.get("https://www.google.co.in/");
	}
}
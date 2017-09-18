package scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown 
{
	private static WebElement webelement(String[] element) throws Exception
	{
		WebDriver driver = BrowserSet.drivreturn();
		if (element[0].equalsIgnoreCase("id"))
			return driver.findElement(By.id(element[1]));
		if (element[0].equalsIgnoreCase("Name"))
			return driver.findElement(By.name(element[1]));
		if (element[0].equalsIgnoreCase("xPath"))
			return driver.findElement(By.xpath(element[1]));
		if (element[0].equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(element[1]));
		return null;
	}
	
	public static void selectbyindex(String[] value,int indx) throws Exception 
	{
		WebElement element=webelement(value);
		Select select=new Select(element);
		select.selectByIndex(indx);
	}
	public static void selectByValue(String[] value,String name) throws Exception 
	{
		WebElement element=webelement(value);
		Select select=new Select(element);
		select.selectByValue(name);
	}
	
}

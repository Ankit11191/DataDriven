package scenario;

import java.util.List;

import org.openqa.selenium.*;

public class SetMethod {

	public static String gettext(String[] element) throws Exception {
		WebDriver driver = BrowserSet.drivreturn();
		if (element[0].equalsIgnoreCase("id"))
			return driver.findElement(By.id(element[1])).getText();
		if (element[0].equalsIgnoreCase("Name"))
			return driver.findElement(By.id(element[1])).getText();
		if (element[0].equalsIgnoreCase("xPath"))
			return driver.findElement(By.xpath(element[1])).getText();
		if (element[0].equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(element[1])).getText();
		if (element[0].equalsIgnoreCase("tagName"))
			return driver.findElement(By.tagName(element[1])).getText();
		return null;
	}

	public static void click(String[] element) throws Exception {
		WebDriver driver = BrowserSet.drivreturn();

		if (element[0].equalsIgnoreCase("id"))
			driver.findElement(By.id(element[1])).click();
		else if (element[0].equalsIgnoreCase("Name"))
			driver.findElement(By.name(element[1])).click();
		else if (element[0].equalsIgnoreCase("xPath"))
			driver.findElement(By.xpath(element[1])).click();
		else if (element[0].equalsIgnoreCase("css"))
			driver.findElement(By.cssSelector(element[1])).click();
		if (element[0].equalsIgnoreCase("tagName"))
			driver.findElement(By.tagName(element[1])).click();
	}

	public static WebElement select(String[] element) throws Exception {
		WebDriver driver = BrowserSet.drivreturn();

		if (element[0].equalsIgnoreCase("id"))
			return driver.findElement(By.id(element[1]));
		if (element[0].equalsIgnoreCase("Name"))
			return driver.findElement(By.name(element[1]));
		if (element[0].equalsIgnoreCase("xPath"))
			return driver.findElement(By.xpath(element[1]));
		if (element[0].equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(element[1]));
		if (element[0].equalsIgnoreCase("tagName"))
			return driver.findElement(By.tagName(element[1]));
		return null;
	}

	public static void sendkey(String[] element, String values)
			throws Exception {
		WebDriver driver = BrowserSet.drivreturn();

		if (element[0].equalsIgnoreCase("id"))
			driver.findElement(By.id(element[1])).sendKeys(values);
		if (element[0].equalsIgnoreCase("Name"))
			driver.findElement(By.name(element[1])).sendKeys(values);
		if (element[0].equalsIgnoreCase("xPath"))
			driver.findElement(By.xpath(element[1])).sendKeys(values);
		if (element[0].equalsIgnoreCase("css"))
			driver.findElement(By.cssSelector(element[1])).sendKeys(values);
		if (element[0].equalsIgnoreCase("tagName"))
			driver.findElement(By.tagName(element[1])).sendKeys(values);
}

	public static void enter(String[] element) throws Exception {
		WebDriver driver = BrowserSet.drivreturn();

		if (element[0].equalsIgnoreCase("id"))
			driver.findElement(By.id(element[1])).sendKeys(Keys.ENTER);
		if (element[0].equalsIgnoreCase("Name"))
			driver.findElement(By.name(element[1])).sendKeys(Keys.ENTER);
		if (element[0].equalsIgnoreCase("xPath"))
			driver.findElement(By.xpath(element[1])).sendKeys(Keys.ENTER);
		if (element[0].equalsIgnoreCase("css"))
			driver.findElement(By.cssSelector(element[1])).sendKeys(Keys.ENTER);
		if (element[0].equalsIgnoreCase("tagName"))
			driver.findElement(By.tagName(element[1])).sendKeys(Keys.ENTER);

	}
	
	public static String tooltip(String[] element) throws Exception {
		WebDriver driver = BrowserSet.drivreturn();
		if (element[0].equalsIgnoreCase("id"))
			return driver.findElement(By.id(element[1])).getAttribute("title").toString();
		if (element[0].equalsIgnoreCase("Name"))
			return driver.findElement(By.name(element[1])).getAttribute("title").toString();
		if (element[0].equalsIgnoreCase("xPath"))
			return driver.findElement(By.xpath(element[1])).getAttribute("title").toString();
		if (element[0].equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(element[1])).getAttribute("title").toString();
		if (element[0].equalsIgnoreCase("tagName"))
			return driver.findElement(By.tagName(element[1])).getAttribute("title").toString();
		return null;
	}	
	
	public static List<WebElement> list(String[] string) {
		WebDriver driver = BrowserSet.drivreturn();

		if (string[0].equalsIgnoreCase("id"))
			return driver.findElements(By.id(string[1]));
		if (string[0].equalsIgnoreCase("Name"))
			return driver.findElements(By.name(string[1]));
		if (string[0].equalsIgnoreCase("xPath"))
			return driver.findElements(By.xpath(string[1]));
		if (string[0].equalsIgnoreCase("css"))
			return driver.findElements(By.cssSelector(string[1]));
		if (string[0].equalsIgnoreCase("tagName"))
			return driver.findElements(By.tagName(string[1]));
		return null;
	}	
}

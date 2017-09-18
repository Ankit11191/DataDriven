package scenario;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
	public static WebDriverWait waitTime() {
		String[] TimeFatch = ReadProerties.propsObjectsSplit("WaitFor");
		int time = Integer.parseInt(TimeFatch[0]);
		WebDriverWait waitTime = new WebDriverWait(BrowserSet.drivreturn(),time);
		return waitTime;
	}

	public static void waitForElemant(String element) {
		try {
			waitTime().until(ExpectedConditions.visibilityOf(SetMethod.select(ReadProerties.propsObjectsSplit(element))));
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void Click(String element) {
		try {
			waitTime().until(ExpectedConditions.elementToBeClickable(SetMethod.select(ReadProerties.propsObjectsSplit(element))));
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void Select(String element) {
		try
		{
			waitTime().until(ExpectedConditions.elementToBeSelected(SetMethod.select(ReadProerties.propsObjectsSplit(element))));
		}
		catch (Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void SwithcToFrame(String element) {
		try 
		{
			waitTime().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(SetMethod.select(ReadProerties.propsObjectsSplit(element))));
		}
		catch (Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void NotVisible(String element) 
	{
		try 
		{
			waitTime().until(ExpectedConditions.invisibilityOf(SetMethod.select(ReadProerties.propsObjectsSplit(element))));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void title(String tital) 
	{
		try 
		{
			waitTime().until(ExpectedConditions.titleIs(tital));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public static void text(String element, String find) 
	{
		try 
		{
			waitTime().until(ExpectedConditions.textToBePresentInElement(SetMethod.select(ReadProerties.propsObjectsSplit(element)),find));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public static void value(String element, String find) 
	{
		try 
		{
			waitTime().until(ExpectedConditions.textToBePresentInElement(SetMethod.select(ReadProerties.propsObjectsSplit(element)),find));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	

}
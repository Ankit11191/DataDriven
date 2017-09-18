package scenario;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CalenderPicker 
{
	public static void datePciker(String date) 
	{
		try {
			SetMethod.click(ReadProerties.propsObjectsSplit("dateBox"));

			List<WebElement> dates = SetMethod.list(ReadProerties.propsObjectsSplit("datePickerXpath"));

			for (WebElement dateItration : dates) 
			{
				String dt = dateItration.getText();
				if (dt.equalsIgnoreCase(date)) 
				{
					dateItration.click();
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			e.getStackTrace();
		}
	}
}
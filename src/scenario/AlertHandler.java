package scenario;

import org.openqa.selenium.Alert;

public class AlertHandler 
{
	static Alert alert=BrowserSet.drivreturn().switchTo().alert();
	

	public static void accept() 
	{
		alert.accept();
	}
	public static void dismiss() 
	{
		// Will click on Cancel button.
		alert.dismiss();
	}
	public static String gettext() 
	{
		//will get the text which is present on the Alert.
	return	alert.getText();
	}
	public static void sendkeys(String Keys) 
	{
		//Will pass the text to the prompt popup
		alert.sendKeys(Keys);
		System.out.println("ankit");
	}

	
	
}

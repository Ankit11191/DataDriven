package scenario;

import java.io.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.*;

public class ScreenShot {
	public static void takesanp() throws Exception {
		String screenshotname = System.currentTimeMillis() + ".png";
		String filepath = "./OutPutFiles/" + screenshotname;
		WebDriver driver = BrowserSet.drivreturn();
		TakesScreenshot shot = ((TakesScreenshot) driver);
		File screenfile = shot.getScreenshotAs(OutputType.FILE); // getScreenshotAs(OutputType.FILE);
		File destfile = new File(filepath);
		FileUtils.copyFile(screenfile, destfile);
	}
}
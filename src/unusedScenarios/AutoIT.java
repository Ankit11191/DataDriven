package unusedScenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIT 
{
	void loadfile() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/External_jars/chromedriver.exe");
		WebDriver driv=new ChromeDriver();

		driv.get("file:///C:/Users/ankit.mittal/Desktop/dropdown.html");
		System.out.println("aaa");

		driv.findElement(By.name("resumupload")).click();
		System.out.println("aaa");

		Runtime.getRuntime().exec(".\\OursourceObject\\ankit.exe "+"D:\\durga.pdf");
		Thread.sleep(3000);
		

	}
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		AutoIT ati=new AutoIT();
		ati.loadfile();
	}
}

package unusedScenarios;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class actions {

	static ExtentReports report;
	static ExtentTest logger; 
	static WebDriver driver;
	 
	 
	@BeforeTest
	public void startReport()
	{
		report=new ExtentReports(System.getProperty("user.dir")+"/report/"+System.currentTimeMillis()+".html",true);
		report.loadConfig(new File("./extent-config.xml"));
	}
	
	@Test
	public void test()
	{
	logger=report.startTest("VerifyBlogTitle");
	System.setProperty("webdriver.chrome.driver", "C:/External_jars/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	logger.log(LogStatus.INFO, "Browser started ");
	driver.get("http://www.learn-automation.com");
	logger.log(LogStatus.INFO, "Application is up and running");
	String title=driver.getTitle();
	 	System.out.println(title); 
	logger.log(LogStatus.PASS, "Title verified");
	}

	@Test
	public void browserClose()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	report.endTest(logger);
	report.flush();

	}
}
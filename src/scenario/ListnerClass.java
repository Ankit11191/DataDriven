package scenario;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListnerClass implements ITestListener {
	public static Logger logger=Logger.getLogger(ListnerClass.class);
	
	@Test
	public void onFinish(ITestContext result) {
		PropertyConfigurator.configure("Log4j.properties");
		System.out.println("Testing has finished and result is"
				+ result.getName());
	}

	@Test
	public void onStart(ITestContext result) {
		System.out.println("Testing has started and result is"
				+ result.getName());
	}

	@Test
	public void onTestFailedButWithinSuccessPercentage(ITestResult sasa) {

	}

	@Test
	public void onTestFailure(ITestResult result) {
		System.out.println("Test has failed and result is"
				+ result.getName());
	}

	@Test
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test has skipped and result is"
				+ result.getName());
	}

	@Test
	public void onTestStart(ITestResult result) {
		System.out.println("Test has started and result is"
				+ result.getName());
	}

	@Test
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test has success and result is"
				+ result.getName());
	}
}

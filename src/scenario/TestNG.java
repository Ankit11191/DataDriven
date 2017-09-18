package scenario;

import org.junit.Test;
import org.testng.annotations.*;

@Listeners

public class TestNG {
	public int i=0;


	@BeforeSuite
	public void beforeSuite(){
	    i++;
	    System.out.println(i+"::BeforeSuite");
	}

	@AfterSuite
	public void afterSuite(){
	    i++;
	    System.out.println(i+"::AfterSuite");
	}

	@BeforeTest
	public void beforeTest(){
	    i++;
	    System.out.println(i+"::BeforeTest");
	}

	@AfterTest
	public void afterTest(){
	    i++;
	    System.out.println(i+"::AfterTest");
	}


	@BeforeGroups
	public void beforeGroups(){
	    i++;
	    System.out.println(i+"::BeforeGroups");
	}

	@AfterGroups
	public void afterGroups(){
	    i++;
	    System.out.println(i+"::AfterGroups");
	}


	@BeforeClass
	public void beforeClass(){
	    i++;
	    System.out.println(i+"::BeforeClass");
	}

	@AfterClass
	public void afterClass(){
	    i++;
	    System.out.println(i+"::AfterClass");
	}


	@BeforeMethod
	public void beforeMethod(){
	    i++;
	    System.out.println(i+"::BeforeMethod");
	}

	@AfterMethod
	public void afterMethod(){
	    i++;
	    System.out.println(i+"::AfterGroups");
	}


	@Test
	public void TestMethod(){
	    i++;
	    System.out.println(i+"::Test");
	}
}

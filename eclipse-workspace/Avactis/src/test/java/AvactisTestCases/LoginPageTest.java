package AvactisTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisResources.Base;

public class LoginPageTest extends Base {
	public static  Logger log = LogManager.getLogger(Base.class.getName());

	
	@BeforeTest(alwaysRun=true)
	public void loadBrowser() throws IOException, InterruptedException 
	{
		
		initializedriver();
		log.info("initialized the driver");
		driver.get(prop.getProperty("url"));
		log.info("fetched the url");
		driver.manage().window().maximize();
	}
	@Test(groups={"Smoke","Regression"})
	public void AdminSignIn() 
	{
		LoginPage loginpage= new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("Password"));
		log.info("admin sign in successfully completed");
		
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown() 
	{
		driver.quit();
		log.info("closed the browser");
	}
	

}

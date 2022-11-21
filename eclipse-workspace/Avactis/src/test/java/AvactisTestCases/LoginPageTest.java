package AvactisTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisResources.Base;

public class LoginPageTest extends Base {
	
	@BeforeTest()
	public void loadBrowser() throws IOException, InterruptedException 
	{
		
		initializedriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test()
	public void AdminSignIn() 
	{
		LoginPage loginpage= new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("Password"));
		
		
	}
	
	@AfterTest()
	public void tearDown() 
	{
		driver.quit();
	}
	

}

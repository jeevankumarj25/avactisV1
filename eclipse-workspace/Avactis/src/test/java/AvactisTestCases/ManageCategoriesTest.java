package AvactisTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisPageObjects.ManageCategoriespage;
import AvactisResources.Base;

public class ManageCategoriesTest extends Base {
	
	@BeforeTest()
	public void loadBrowser() throws IOException, InterruptedException 
	{
		initializedriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test()
	public void createSubCategory() throws InterruptedException {
	LoginPage loginpage = new LoginPage();
	loginpage.login(prop.getProperty("username"), prop.getProperty("Password"));
	ManageCategoriespage mcp= new ManageCategoriespage();
	mcp.clickoncatalogue();
	Thread.sleep(1000L);
	mcp.clickonManagecategoriesBtn();
	mcp.clickonSubcategory();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cboxIframe']")));
	mcp.writeSubcategoryname(prop.getProperty("Subcategoryname"));
	mcp.clickonSubcategorysaveBtn();
	
	}

	@AfterTest()
	public void tearDown() 
	{
		driver.quit();
	}
}

package AvactisTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisPageObjects.ManageCategoriespage;
import AvactisResources.Base;

public class ManageCategoriesTest extends Base {
	public static  Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest(alwaysRun=true)
	public void loadBrowser() throws IOException, InterruptedException 
	{
		initializedriver();
		log.info("initialized the driver");
		driver.get(prop.getProperty("url"));
		log.info("Fetched the url");
		driver.manage().window().maximize();
	}
	@Test(groups={"Smoke","Regression"})
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
	log.info("successfully created subcategory");
	
	}

	@AfterTest(alwaysRun=true)
	public void tearDown() 
	{
		driver.quit();
		log.info("closed the browser");
	}
}

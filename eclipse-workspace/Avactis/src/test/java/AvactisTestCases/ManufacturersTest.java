package AvactisTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisPageObjects.ManufacturersPage;
import AvactisResources.Base;

public class ManufacturersTest extends Base{
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
	@Test(groups={"Smoke","Regression","Sanity"})
	public void AddManufacturer() 
	{
		LoginPage loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("Password"));
		ManufacturersPage mp= new ManufacturersPage();
		mp.clickOnCatalogue();
		mp.clickOnManufacturer();
		Assert.assertTrue(mp.validatemanufacturerPage());
		mp.clickOnAddManufacturer();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cboxIframe']")));
		mp.enterManufacturerName(prop.getProperty("manufacturername"));
		driver.findElement(By.xpath("//input[@id='ii_input_file_mnf_image']")).sendKeys("C:\\Users\\DELL\\eclipse-workspace\\Avactis\\Files\\honda.jpg");
		mp.WriteManufacturereurlbox(prop.getProperty("manufacturerurl"));
		mp.ManufacturereSaveBtn();
		log.info("Successfully added the manufacturer");
	}

	
	@AfterTest(alwaysRun=true)
	public void tearDown() 
	{
		driver.quit();
	}
}

package AvactisTestCases;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisPageObjects.ManageProductspage;
import AvactisResources.Base;

public class ManageProductsTest extends Base {
	public static  Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest(alwaysRun = true)
	public void loadBrowser() throws IOException, InterruptedException 
	{
		initializedriver();
		log.info("initialized the driver");
		driver.get(prop.getProperty("url"));
		log.info("Fetched the url");
		driver.manage().window().maximize();
	}
	@Test(groups={"Smoke","Regression","Sanity"})
	public void AddProduct() throws InterruptedException 
	{
		LoginPage loginpage= new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("Password"));
		ManageProductspage mpp= new ManageProductspage();
		mpp.ClickonCatalg();
		mpp.ClickonManageProducts();
		mpp.ClickonAddProductsBtn();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cboxIframe']")));
		Assert.assertTrue(mpp.validateaddnewproduct());
		Select s = new Select(driver.findElement(By.name("SelectTypeID")));
		s.selectByVisibleText("Computers");
		mpp.enterProductName(prop.getProperty("productname"));
		Thread.sleep(1000L);
		mpp.enterProductprice(prop.getProperty("productPrice"));
		mpp.ClickonSaveBtn();	
		log.info("Successfully added the product");
	}
	@Test(groups={"Regression"})
	public void MoveProduct() throws InterruptedException  
	{
		try {
		List<WebElement>products=driver.findElements(By.xpath("//form[@name='ProductListing']/table/tbody/tr/td[3]"));
		for(int i=0;i<products.size();i++) 
		{
			String Allproductids=products.get(i).getText();
			if(Allproductids.contentEquals(prop.getProperty("productid"))) 
			{
				WebElement select=driver.findElements(By.name("cat_id")).get(i);
				Select s= new Select(select);
				s.selectByVisibleText("Computers");
				driver.findElement(By.xpath("//div[@onclick='OnMoveButtonClick(selectedcatid());']")).click();
				
			}
		}

		}
		catch(Exception e) 
	  {
		e.printStackTrace();
	  }
		log.info("successfully moved the product");
	}
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		log.info("closed the browser successfully");
	}
}

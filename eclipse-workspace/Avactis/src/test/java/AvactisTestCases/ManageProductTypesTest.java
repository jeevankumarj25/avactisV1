package AvactisTestCases;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisPageObjects.ManageCategoriespage;
import AvactisPageObjects.ManageProductTypesPage;
import AvactisResources.Base;

public class ManageProductTypesTest extends Base {
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
	public void AddNewProductType() 
	{
		LoginPage loginpage= new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("Password"));
		ManageCategoriespage mcp=new ManageCategoriespage();
		mcp.clickoncatalogue();
		ManageProductTypesPage mpt= new ManageProductTypesPage();
		mpt.clickonManageproductTypesBtn();
		mpt.clickonAddnewproductTypesBtn();
		mpt.AddnewproductTypesBtn(prop.getProperty("producttypename"), prop.getProperty("ProducttypeDesc"), prop.getProperty("ProductPrice"));
		String actual=mpt.validateProductTypesTitle();
		Assert.assertEquals(actual, "Manage Product Types");
		mpt.ClickOnDeleteproductTypesBtn();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cboxIframe']")));
		List<WebElement>products=driver.findElements(By.xpath("//table[@class='list']/tbody/tr/td[2]"));
		for(int i=0;i<products.size();i++) 
		{
			String AllProducts=products.get(i).getText();
			if(AllProducts.equalsIgnoreCase(prop.getProperty("productypedeletin"))) 
			{
				driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
			}
		}
		mpt.ClickOnDeleteproductTypesBtn2();
		driver.switchTo().alert().accept();
		log.info("Successfully added new product type");
	}

	@AfterTest(alwaysRun=true)
	public void tearDown() 
	{
		driver.quit();
		log.info("closed the browser");
	}
}

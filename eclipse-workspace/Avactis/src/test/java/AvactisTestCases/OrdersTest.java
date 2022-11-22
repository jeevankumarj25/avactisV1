package AvactisTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisPageObjects.OrdersPage;
import AvactisResources.Base;

public class OrdersTest extends Base {
	public static  Logger log = LogManager.getLogger(Base.class.getName());

	
	@BeforeTest(alwaysRun=true)
	public void loadBrowser() throws IOException, InterruptedException 
	{
		initializedriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test(groups={"Smoke","Regression"})
	public void UpdateOrderStatus() 
	{
		LoginPage lp= new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		OrdersPage op= new OrdersPage();
		op.clickOnOrdersBtn();
		op.enterOrderNum(prop.getProperty("orderNo"));
		op.clickonSearchBtn();
		Select orderStatus = new Select(driver.findElement(By.xpath("//table[@class='list']/tbody/tr[2]/td[9]/select")));
		orderStatus.selectByVisibleText(prop.getProperty("orderStatus"));
		
		Select paymentStatus = new Select(driver.findElement(By.xpath("//select[contains(@name,'payment_status_id')]")));
		paymentStatus.selectByVisibleText(prop.getProperty("paymentStatus"));
		op.clickonUpdateBtn();
		Assert.assertEquals(op.validateUpdateStatus(), "Order data has been updted");
		log.info("order status has been updated");
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown() 
	{
		driver.quit();
	}
}

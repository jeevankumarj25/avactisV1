package AvactisTestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.CustomersPage;
import AvactisPageObjects.LoginPage;
import AvactisResources.Base;
import AvactisResources.CommonMethods;

public class CustomerspageTest extends Base {
	
	CustomersPage cp;

	@BeforeTest()
	public void loadBrowser() throws IOException, InterruptedException {

		initializedriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test()
	public void CreateCustmersGrp() {
		LoginPage loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("Password"));
		cp = new CustomersPage();
		cp.clckonCustomersBtn();
		cp.clckonCustomersBtn2();
		cp.clckonCustomerGrpButton();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cboxIframe']")));
		cp.enterNewGrpName(prop.getProperty("GroupName"));
		cp.createGrpAddBtn();
		cp.CloseCreateGrp();
		driver.navigate().refresh();
	}

	@Test()
	public void ExportCsv() throws InterruptedException {
		cp.clickOnExport();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cboxIframe']")));
		cp.checkEmailBox();
		cp.ExportStartBtn();
		Thread.sleep(7000L);
		cp.ClickonDownloadCsv();
		Thread.sleep(3000L);
		cp.ClosePopup();
		driver.navigate().refresh();
	}

	@Test()
	public void ResetPassword() throws Exception {

		try {
			List<WebElement> customernames = driver.findElements(By.xpath("//div[@class='fixed_height_menu_tab_page']/table/tbody/tr/td/table[4]/tbody/tr/td[3]"));
			for (int i = 0; i < customernames.size(); i++) {
				String particularcustomer = customernames.get(i).getText();
				if ((particularcustomer).contentEquals(prop.getProperty("customerName"))) {
					WebElement select = driver.findElements(By.tagName("select")).get(i + 1);
					Select s = new Select(select);
					s.selectByVisibleText(prop.getProperty("customerSubscription"));
					cp.clickonResetBtn();
					driver.switchTo().alert().accept();
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath("//span[text()='Account passwords reset successfully.']")));
					Assert.assertEquals("Account passwords reset successfully.", cp.validatepassReset());
					driver.navigate().refresh();
				
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test()
	public void activatePassword() 
	{
		try {
			List<WebElement> customernames = driver.findElements(By.xpath("//div[@class='fixed_height_menu_tab_page']/table/tbody/tr/td/table[4]/tbody/tr/td[3]"));
			for (int i = 0; i < customernames.size(); i++) {
				String particularcustomer = customernames.get(i).getText();
				if ((particularcustomer).contentEquals(prop.getProperty("customerName"))) {
					WebElement select = driver.findElements(By.tagName("select")).get(i + 1);
					Select s = new Select(select);
					s.selectByVisibleText(prop.getProperty("customerSubscription"));
					cp.clickOnActivateBtn();
					driver.switchTo().alert().accept();
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath("//span[text()='Accounts activated successfully.']")));
					Assert.assertTrue(cp.validateActivate());
				
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@AfterTest()
	public void tearDown() 
	{
		driver.quit();
	}
	
	
	
}







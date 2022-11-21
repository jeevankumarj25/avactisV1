package AvactisTestCases;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisPageObjects.LoginPage;
import AvactisPageObjects.ReviewsPage;
import AvactisResources.Base;

public class ReviewTest extends Base {
	public static  Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest(alwaysRun=true)
	public void loadBrowser() throws IOException, InterruptedException {
		initializedriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test(groups={"Regression","Sanity"})
	public void SearchReview() {

		LoginPage loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("Password"));
		ReviewsPage rp = new ReviewsPage();
		rp.clickOnCustomerBtn();
		rp.clickonReviews();
		rp.clickonAllReviews();
		Select s1 = new Select(driver.findElement(By.cssSelector("select[name='from_day']")));
		s1.selectByVisibleText(prop.getProperty("FromDate"));
		Select s2 = new Select(driver.findElement(By.cssSelector("select[name='from_month']")));
		s2.selectByVisibleText(prop.getProperty("FromMonth"));
		Select s3 = new Select(driver.findElement(By.cssSelector("select[name='from_year']")));
		s3.selectByVisibleText(prop.getProperty("FromYear"));

		Select s4 = new Select(driver.findElement(By.cssSelector("select[name='to_day']")));
		s4.selectByVisibleText(prop.getProperty("ToDate"));
		Select s5 = new Select(driver.findElement(By.cssSelector("select[name='to_month']")));
		s5.selectByVisibleText(prop.getProperty("ToMonth"));
		Select s6 = new Select(driver.findElement(By.cssSelector("select[name='to_year']")));
		s6.selectByVisibleText(prop.getProperty("ToYear"));
		rp.clickonSearchBtn();
		List<WebElement> products = driver.findElements(By
				.xpath("//form[@id='SearchResults']/table[2]/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a"));
		System.out.println(products);
		for (int i = 0; i < products.size(); i++) {
			String productnames = products.get(i).getText();
			System.out.println(productnames);
			if (productnames.contentEquals("HP TouchSmart")) {
				WebElement select = driver.findElements(By.xpath("//select[contains(@id,'data')]")).get(i);
				String ApproveorNot = new Select(select).getFirstSelectedOption().getText();
				if (ApproveorNot.contentEquals("Approved")) {
					Select s = new Select(select);
					s.selectByVisibleText("Not Approved");
				} else {
					Select s = new Select(select);
					s.selectByVisibleText("Approved");
				}

			}

		}
		rp.clickonupdateReview();
		Assert.assertTrue(rp.validateStatuschange());
		log.info("Search review completed");
	}

	@AfterTest(alwaysRun=true)
	public void tearDown() 
	{
		driver.quit();
	}
}

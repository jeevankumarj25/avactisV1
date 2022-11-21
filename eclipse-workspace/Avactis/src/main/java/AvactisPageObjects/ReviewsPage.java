package AvactisPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AvactisResources.Base;

public class ReviewsPage extends Base{
	//Reviews webelements
	@FindBy(xpath="//img[@title='Customers']")
	WebElement customersBtn;
	
	@FindBy(xpath="//a[@href='customer_reviews.php']")
	WebElement ReviewBtn;
	
	@FindBy(css="select[name='from_day']")
	WebElement FromDaydropDown;
	
	@FindBy(css="select[name='from_month']")
	WebElement FromMonthdropdown;
	
	@FindBy(css="select[name='from_year']")
	WebElement FromYeardropdown;
	
	@FindBy(css="select[name='to_day']")
	WebElement ToDaydropDown;
	
	@FindBy(css="to_month")
	WebElement ToYearDown;
	
	@FindBy(css="select[name='to_year']")
	WebElement ToYeardropdown;
	
	@FindBy(xpath="//div[contains(text(),'Search')]")
	WebElement SearchBtn;
	
	@FindBy(css="a[href='customer_reviews.php?asc_action=ShowAllReviews']")
	WebElement allreviewsBtn;
	
	@FindBy(id="UpdateButton2")
	WebElement reviewUpdateBtn;
	
	@FindBy(xpath="//span[text()='Statuses have been changed.']")
	WebElement ValidateApproveStatus;
	
	public  ReviewsPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCustomerBtn() 
	{
		customersBtn.click();
	}
	
	public void clickonReviews() 
	{
		ReviewBtn.click();
	}
	
	
	public void clickonSearchBtn() 
	{
		SearchBtn.click();
	}
	
	public void clickonAllReviews() 
	{
		allreviewsBtn.click();
	}
	
	public void clickonupdateReview() 
	{
		reviewUpdateBtn.click();
	}
	
	public boolean validateStatuschange() 
	{
		return ValidateApproveStatus.isDisplayed();
	}
	
}

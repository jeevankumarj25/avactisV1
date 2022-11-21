package AvactisPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvactisResources.Base;

public class OrdersPage  extends Base{
	
	@FindBy(css="img[title='Orders']")
	WebElement ordersBtn;
	
	@FindBy(css="input[name='order_id']")
	WebElement orderIDTextbox;
	
	@FindBy(xpath="//form[@name='SearchById'] //div[@class='button button_5em']")
	WebElement SearchBtn;
	
	@FindBy(xpath="//div[@id='UpdateButton2']")
	WebElement UpdateBtn;
	
	
	@FindBy(xpath="//span[contains(text(),'Order data has been updated')]")
	WebElement getUpdateStatus;
	
	
	public  OrdersPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOrdersBtn() 
	{
		ordersBtn.click();
	}
	
	
	public void enterOrderNum(String orderNo) 
	{
		orderIDTextbox.sendKeys(orderNo);
	}
	
	public void clickonSearchBtn() 
	{
		SearchBtn.click();
	}
	
	public void clickonUpdateBtn() 
	{
		UpdateBtn.click();
	}
	
	public String validateUpdateStatus() 
	{
		return getUpdateStatus.getText();
	}

}

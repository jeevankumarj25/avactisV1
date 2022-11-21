package AvactisPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvactisResources.Base;

public class CustomersPage extends Base {
	//create customer grp web elements
	@FindBy(xpath="//img[@title='Customers']")
	WebElement customersBtn;
	
	@FindBy(xpath="//a[@href='customers.php']/span")
	WebElement customersBtn2;
	
	@FindBy(id="CustomerGroupsButton2")
	WebElement CustomerGrpButton;
	
	@FindBy(id="new_group")
	WebElement newGroupTextbox;
	
	@FindBy(id="AddGroupButton")
	WebElement AddGroupBtn;
	
	@FindBy(xpath="//span[text()='Customer group added successfully.']")
	WebElement getcustomerGroupPage;
	
	@FindBy(xpath="//div[text()='Close']")
	WebElement closeBtn;
	
	//export customer web elements
	
	@FindBy(id="ExportButton2")
	WebElement exportBtn;
	
	@FindBy(id="infotag_Email")
	WebElement checkboxEmail;
	
	@FindBy(id="StartButton1")
	WebElement exportStartBtn;
	
	@FindBy(id="DownloadCSVButton1")
	WebElement DownloadCsvBtn;
	
	@FindBy(css="tr[id='section_2'] div[class='button button_small']")
	WebElement ClosePopup;
	
	//create ResetPassword web elements
	
	@FindBy(id="DropPasswdButton2")
	WebElement PassResetBtn;
	
	
	@FindBy(xpath="//span[text()='Account passwords reset successfully.']")
	WebElement ValidatepassReset;
	
	//create AcivatePassword web elements
	
		@FindBy(id="ActivateButton2")
		WebElement PassActivateBtn;
		
		@FindBy(xpath="//span[text()='Accounts activated successfully.']")
		WebElement getActivatedMsg;
	
	
	//Customer page methods
	public  CustomersPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clckonCustomersBtn() 
	{
		customersBtn.click();
	}
	
	public void clckonCustomersBtn2() 
	{
		customersBtn2.click();
	}

	public void clckonCustomerGrpButton() 
	{
		CustomerGrpButton.click();
	}
	
	public void enterNewGrpName(String GroupName) 
	{
		newGroupTextbox.sendKeys(GroupName);
	}
	
	public void createGrpAddBtn() 
	{
		AddGroupBtn.click();
	}
	
	public void validateCreateGrpPage() 
	{
		getcustomerGroupPage.isDisplayed();
	}
	
	public void CloseCreateGrp() 
	{
		closeBtn.click();
	}
	
	//Export customers Methods
	
	public void clickOnExport() 
	{
		exportBtn.click();
	}
	
	public void checkEmailBox() 
	{
		checkboxEmail.click();
	}
	
	public void ExportStartBtn() 
	{
		exportStartBtn.click();
	}
	
	public void ClickonDownloadCsv() 
	{
		DownloadCsvBtn.click();
	}
	
	public void ClosePopup() 
	{
		ClosePopup.click();
	}
	
	
	// customers ResetPasswords Methods
	public void clickonResetBtn() 
	{
		PassResetBtn.click();
	}
	
	public String validatepassReset() 
	{
		return ValidatepassReset.getText();
	}
	
	// customers ActivatePasswords Methods
	
	public void clickOnActivateBtn() 
	{
		 PassActivateBtn.click();
	}
	
	public boolean validateActivate() 
	{
		return getActivatedMsg.isDisplayed();
	}
}

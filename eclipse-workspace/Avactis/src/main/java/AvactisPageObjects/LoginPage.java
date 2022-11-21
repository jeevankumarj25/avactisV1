package AvactisPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvactisResources.Base;

public class LoginPage extends Base {
	@FindBy(name="AdminEmail")
	WebElement adminusernamebox;
	
	@FindBy(name="Password")
	WebElement adminpasswordbox;
	
	@FindBy(id="SignInButton1")
	WebElement adminSigninButton;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
		
	public ManageProductspage login(String username,String password) 
	{
		adminusernamebox.sendKeys(username);
		adminpasswordbox.sendKeys(password);
		adminSigninButton.click();
		return new ManageProductspage();
		
		
		
		
	}
	
	
	}

	


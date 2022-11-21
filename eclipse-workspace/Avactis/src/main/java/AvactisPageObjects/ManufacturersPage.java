package AvactisPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvactisResources.Base;

public class ManufacturersPage extends Base {

	//manufacturers webElements
	@FindBy(xpath="//img[@title='Catalog']")
	WebElement catalogueBtn;
	
	@FindBy(xpath="//a[@href='mnf_manufacturers.php']")
	WebElement ManufacturersBtn;
	
	@FindBy(xpath="//div[@class='button button_10em']")
	WebElement AddManufacturerBtn;
	
	@FindBy(xpath="//input[@name='ManufacturerName']")
	WebElement ManufacturerNameTextBox;
	
	@FindBy(id="ii_input_file_mnf_image")
	WebElement chooseFileBtn;
	
	@FindBy(id="ii_input_file_mnf_image")
	WebElement uploadManufacturerimgBtn;
	
	@FindBy(name="ManufacturerUrl")
	WebElement Manufacturereurlbox;
	
	@FindBy(id="SaveButton1")
	WebElement ManufacturerSaveBtn;
	
	@FindBy(xpath="//span[text()='Manage manufacturers']")
	WebElement getmanufacturepagetitle;
	
	//Manufacturers methods
	
	public  ManufacturersPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCatalogue() 
	{
		catalogueBtn.click();
	}
	
	public void clickOnManufacturer() 
	{
		ManufacturersBtn.click();
	}
	
	public void clickOnAddManufacturer() 
	{
		AddManufacturerBtn.click();
	}
	
	public void enterManufacturerName(String manufacturername) 
	{
		ManufacturerNameTextBox.sendKeys(manufacturername);
	}
	
	public void chooseManufacturerImg(String Image) 
	{
		chooseFileBtn.sendKeys(Image);
	}
	
	public void uploadManufacturerImg() 
	{
		uploadManufacturerimgBtn.click();
	}
	
	public void WriteManufacturereurlbox(String manufacturerurl) 
	{
		Manufacturereurlbox.sendKeys(manufacturerurl);
	}
	
	public void ManufacturereSaveBtn() 
	{
		ManufacturerSaveBtn.click();
	}
	
	public boolean validatemanufacturerPage() 
	{
		return getmanufacturepagetitle.isDisplayed();
	}
	
}

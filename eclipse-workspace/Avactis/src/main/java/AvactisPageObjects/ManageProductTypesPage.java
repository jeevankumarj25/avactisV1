package AvactisPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvactisResources.Base;

public class ManageProductTypesPage extends Base {

	
	
	@FindBy(xpath="//a[@href='catalog_manage_product_types.php']")
	WebElement ManageproductTypesBtn;
	
	@FindBy(css="div[title='Add new product type']")
	WebElement AddnewproductTypesBtn;
	
	@FindBy(css="input[name='TypeName']")
	WebElement ProductTypeTextBox;
	
	@FindBy(css="input[name='TypeDescr']")
	WebElement ProductTypeDescTextBox;
	
	@FindBy(id="SalePrice")
	WebElement ProductpriceTextBox;
	
	@FindBy(id="SaveButton1")
	WebElement productSaveBtn;
	
	@FindBy(css="div[title='Delete product type(s)']")
	WebElement DeleteproductTypesBtn;
	
	@FindBy(xpath="//td[text()='Manage Product Types']")
	WebElement getProducttypestitle;
	
	@FindBy(xpath="//td[text()='Product types to be deleted']")
	WebElement DeleteProductTypetitle;
	
	@FindBy(id="DeleteButton1")
	WebElement DeleteProductBtn;
	
	public  ManageProductTypesPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonManageproductTypesBtn() 
	{
		ManageproductTypesBtn.click();
	}
	
	public void clickonAddnewproductTypesBtn() 
	{
		AddnewproductTypesBtn.click();
	}
	
	public void AddnewproductTypesBtn(String producttypename,String ProducttypeDesc,String ProductPrice) 
	{
		ProductTypeTextBox.sendKeys(producttypename);
		ProductTypeDescTextBox.sendKeys(ProducttypeDesc);
		ProductpriceTextBox.sendKeys(ProductPrice);
		productSaveBtn.click();	
	}
	
	public String validateProductTypesTitle() 
	{
		return getProducttypestitle.getText();
	}
	
	public void ClickOnDeleteproductTypesBtn() 
	{
		DeleteproductTypesBtn.click();;
	}
	
	public void ClickOnDeleteproductTypesBtn2() 
	{
		DeleteProductBtn.click();
	}
	
}

package AvactisPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvactisResources.Base;

public class ManageProductspage extends Base {
	
	//WebElements of ManageProductsModule
	@FindBy(xpath="//img[@title='Catalog']")
	WebElement catalogelement;
	
	@FindBy(xpath="//a[@href='catalog_manage_products.php']")
	WebElement ManageProductsBtn;
	
	@FindBy(xpath="//div[@class='button button_8em']")
	WebElement AddProductsBtn;
	
	@FindBy(name="SelectTypeID")
	WebElement selectProduct;
	
	@FindBy(id="Name")
	WebElement enterproductName;
	
	@FindBy(id="SalePrice")
	WebElement entersalesprice;
	
	@FindBy(id="SaveButton2")
	WebElement ProductSaveBtn;
	
	@FindBy(xpath="//td[text()='Add New Product']")
	WebElement validateaddnewProductPage;
	
	//methods of manageProducts Module
	public ManageProductspage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonCatalg() 
	{
		catalogelement.click();
	}
	
	public void ClickonManageProducts() 
	{
		ManageProductsBtn.click();
	}
	
	public void ClickonAddProductsBtn() 
	{
		AddProductsBtn.click();
	}
	
	public void selectProduct() 
	{
		selectProduct.click();
	}
	
	public void enterProductName(String productname) 
	{
		enterproductName.sendKeys(productname);;
	}
	
	public void enterProductprice(String productPrice) 
	{
		entersalesprice.sendKeys(productPrice);;
	}
	
	public void ClickonSaveBtn() 
	{
		ProductSaveBtn.click();
	}
	
	public  boolean validateaddnewproduct() 
	{
		 return validateaddnewProductPage.isDisplayed();
	}
	
}
	
	
	

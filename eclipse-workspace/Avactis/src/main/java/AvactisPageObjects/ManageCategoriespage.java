package AvactisPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvactisResources.Base;

public class ManageCategoriespage extends Base {
	
	@FindBy(xpath="//a[@href='catalog_manage_categories.php']")
	WebElement manageCategoriesBtn;
	
	@FindBy(id="mng_ctg_add")
	WebElement createsubcategoryBtn;
	
	@FindBy(name="Subcategory")
	WebElement SubCategoryname;
	
	@FindBy(id="SaveButton2")
	WebElement SubcategorysaveBtn;
	
	@FindBy(xpath="//img[@title='Catalog']")
	WebElement catalogueBtn;
	
	
	
	public  ManageCategoriespage() 
	{
		PageFactory.initElements(driver, this);
	}
	

	public void clickoncatalogue() 
	{
		catalogueBtn.click();
		
	}
	
	public void clickonSubcategory() 
	{
		createsubcategoryBtn.click();
		
	}
	
	public void writeSubcategoryname(String Subcategoryname) 
	{
		SubCategoryname.sendKeys(Subcategoryname);
		
	}
	
	public void clickonSubcategorysaveBtn() 
	{
		SubcategorysaveBtn.click();
		
	}
	
	public void clickonManagecategoriesBtn() 
	{
		manageCategoriesBtn.click();
		
	}
	

}

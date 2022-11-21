package AvactisResources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AvactisPageObjects.CustomersPage;

public class CommonMethods extends Base {
	public CustomersPage common() {
	List<WebElement> customernames = driver.findElements(By.xpath("//div[@class='fixed_height_menu_tab_page']/table/tbody/tr/td/table[4]/tbody/tr/td[3]"));
	for (int i = 0; i < customernames.size(); i++) {
		String particularcustomer = customernames.get(i).getText();
		if ((particularcustomer).contentEquals(prop.getProperty("customerName"))) {
			WebElement select = driver.findElements(By.tagName("select")).get(i + 1);
			Select s = new Select(select);
			s.selectByVisibleText(prop.getProperty("customerSubscription"));
			
}
	}
	return new CustomersPage() ;
	
}
	
}



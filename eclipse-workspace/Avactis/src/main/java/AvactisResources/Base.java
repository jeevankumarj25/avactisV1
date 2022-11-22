package AvactisResources;
import java.io.File;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializedriver() throws IOException 
	{
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Avactis\\src\\main\\java\\AvactisResources\\configuration.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chrome\\chromedriver.exe");       
	         driver = new ChromeDriver();
		}
		else if(browsername.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\firefox\\geckodriver.exe");
			 driver= new FirefoxDriver();  
		}
		
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\DELL\\Desktop\\IE\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver(); 
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		return driver;	
	}
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException 
	{
	TakesScreenshot ts= (TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String Destination=System.getProperty("user.dir")+"\\reports\\testcasename.png";
	FileUtils.copyFile(source, new File(Destination));
	return Destination;
	}
}

package AvactisTestCases;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import AvactisResources.Base;

public class ExtentReportsNG extends Base {
	static ExtentReports extent;
	public static ExtentReports getExtentReports() 
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation test");
		reporter.config().setDocumentTitle("AutomationReport");
	    extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Jeevan Kumar", "Test Engineer");
		return extent;
		
		
	}
}

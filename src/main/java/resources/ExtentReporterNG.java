package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent; // Defining object of extent report globally to use in every method
	
	public static ExtentReports getReportObject() { //defining method as static to use in listener class
		
		String path= System.getProperty("user.dir")+"\\reports\\index.html"; //Creating path for extent reports
		ExtentSparkReporter reporter= new ExtentSparkReporter(path); //To configure reports and its path to store
		reporter.config().setReportName("Web Automation Results"); //Creating name for report file
		reporter.config().setDocumentTitle("Web Test Results"); //Header tab name for report document
		
		extent=new ExtentReports(); //Creating object for extent reports To drive all the config done above for reports
		extent.attachReporter(reporter); //Creating bond between both objects to drive reports config
		extent.setSystemInfo("Tester", "Shubham Singh"); //Setting designation and tester name
		return extent; //To use all config of report generating in every methods
	}
}

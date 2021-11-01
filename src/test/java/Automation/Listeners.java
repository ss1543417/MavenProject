package Automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.MavenBase;

public class Listeners extends MavenBase implements ITestListener { //This is listener interface which will implement testng listeners in this listener class

	ExtentTest	test; //Defining test globally so that it can be used in every method
	ExtentReports extent=ExtentReporterNG.getReportObject(); //Calling extent method to use its config in every test case; //Defining extent globally so that it can be used in every method
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>(); //Creating ThreadLocal to keep test ExtentTest thread safe in parallel execution
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 
	 	test=extent.createTest(result.getMethod().getMethodName()); //Creating test to create tc in reports and also log pass n fail in test cases
		extentTest.set(test); //This will take test object value and responsible for maintaing or give right object(test) when fail or pass test results acc to test cases in parallel execution
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().log(Status.PASS, "Test Passed"); //It will pass as status with description test passed in reports
		//Screenshots
		WebDriver driver=null; //dummy webdriver its not having life
		//Screenshots
		String testMethodName=result.getMethod().getMethodName(); //This result will give the method name which got failed
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPathP(testMethodName,driver), result.getMethod().getMethodName());//We are also getting test case name for ss
			//We are getting path of ss as well
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Sending the passed test case name from getSSP
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().fail(result.getThrowable()); //It will pass log for failed test case in reports
		
		WebDriver driver=null; //dummy webdriver its not having life
		//Screenshots
		String testMethodName=result.getMethod().getMethodName(); //This result will give the method name which got failed
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());//We are also getting test case name for ss
			//We are getting path of ss as well
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Sending the failed test case name from getSSP
		
		
			}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush(); //To stop config report once every test case is executed
		
	}
	
	

}

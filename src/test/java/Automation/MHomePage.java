package Automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.IteraPage;
import resources.MavenBase;

public class MHomePage extends MavenBase {

	public WebDriver driver; //Defining local driver to take properties from base class and execute cases in parallel
	@Test
	public void pagesNavigation() throws IOException {
		
		driver=mvninitializedriver(); //Calling mvninitializedriver method in pagesNavigation method returning drive
		
		driver.get(mprop.getProperty("url")); //Getting url from data properties file to run test case
		driver.manage().window().maximize(); // Use to maximize the screen
		
		IteraPage ip= new IteraPage(driver); //Creating IteraPage to access its methods
		 //Sending values to each components by its methods
		ip.IteraName().sendKeys("Shubham Singh");
		ip.IteraMobilenumber().sendKeys("12345");
		ip.IteraEmail().sendKeys("s@gmaiol.com");
		ip.IteraPassword().sendKeys("123456");
		ip.IteraAddress().sendKeys("abcxyz");
		ip.IteraSubmit().click();
		
		
	}
}

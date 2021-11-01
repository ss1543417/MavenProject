package Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.IteraPage;
import resources.MavenBase;

public class validateRadionCheckbox extends MavenBase{
	
   public WebDriver driver;//Defining local driver to take properties from base class and execute cases in parallel
   
   public static Logger log =LogManager.getLogger(MavenBase.class.getName()); //To use all logging mechanism
	
   IteraPage ip; //Defining Itera page object globally to use in multiple test cases
   
   @BeforeTest
   public void initialize() throws IOException {
	   
	   driver=mvninitializedriver(); //Calling mvninitializedriver method invalidateRadionCheckbox method 
	   driver.get(mprop.getProperty("url"));//To invoke the url
	   driver.manage().window().maximize(); // Use to maximize the screen
	   ip= new IteraPage(driver); //Creating IteraPage object to access its methods
   }
   
   @Test
   public void validateRadiobutton() {
	   
	  ip.IteraFemale().click(); //This will click on female radio button
	  Assert.assertTrue( ip.IteraFemale().isSelected(),"Gender Female button is not selected");//If not selected it will trigger this message
	   
   }
   
   @Test
   public void validateCheckBox() {
	  
	   ip.IteraMonday().click(); //This will click on female radio button
	   log.info("Monday CheckBox is selected");
	   
   }
   @Test
   public void validateTravelDropDown() {
	   
	   ip.IteraDropDown().sendKeys("Turkey"); //This will enter turkey value in dropdown value
   }
   
	
	
	
	

}

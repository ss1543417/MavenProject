package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IteraPage {
	
	public WebDriver driver; //Created a selenium object for Itera page
	
	 private By name= By.id("name"); //To click on name field
	 private By mobilenumber= By.xpath("//input[@type='text']"); //To click on mobilenumber field
	 private By email= By.cssSelector("[id='email']"); //To click on email field
	 private By password= By.cssSelector("#password"); //To click on password field
	 private By address= By.cssSelector("textarea.form-control"); //To click on address field
	@FindBy(xpath="//button[contains(@class,'btn-primary')]") //To click on submit button 
	WebElement submit;
	 private By female= By.cssSelector("[id='female']"); //To click on radio button of gender female
	 private By monday=By.id("monday"); //To click on monday check box
	 private By dropdown=By.cssSelector("select.custom-select"); //To select dropdown field
	
	public IteraPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);//Assigning life to local variable from base class
	}

	public WebElement IteraName() {
		
		return driver.findElement(name); //Returning Name webelement
	}
	 
      public WebElement IteraMobilenumber() {
		
		return driver.findElement(mobilenumber); //Returning mobilenumber webelement
	}
	
      public WebElement IteraEmail() {
  		
    	  return driver.findElement(email); //Returning email webelement
  	}
      public WebElement IteraPassword() {
    		
    	  return driver.findElement(password); //Returning password webelement
  	}
      
      public WebElement IteraAddress() {
  		
    	  return driver.findElement(address); //Returning password webelement
  	}
     
      public WebElement IteraSubmit() {
		
		
		return submit; //Returning Submit webelement
	}
	
      public WebElement IteraFemale() {
    		
    	  return driver.findElement(female); //Returning female webelement
  	}
      public WebElement IteraMonday() {
  		
    	  return driver.findElement(monday); //Returning monday webelement
  	} 
      public WebElement IteraDropDown() {
    		
    	  return driver.findElement(dropdown); //Returning dropdown webelement
  	} 
}

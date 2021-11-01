package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangeHRM {
	
	public WebDriver driver; //Created a selenium object for Itera page
	
	By username=By.id("txtUsername"); //Webelement for username
	By password=By.name("txtPassword"); //Webelement for password
	
	//By login= By.xpath("//input[@value='LOGIN']"); //Webelemet for Login tab
	@FindBy(xpath="//input[@value='LOGIN']")
	WebElement login; //Webelemet for Login tab
	
	public WebElement orangeUsername() {
		
		return driver.findElement(username); //Returning username 
	}
	
    public WebElement orangePassword() {
		
		return driver.findElement(password); //Returning password 
	}
    
    public WebElement orangeLogin() {
		
		 return login; //Returning password 
	} 
	
}

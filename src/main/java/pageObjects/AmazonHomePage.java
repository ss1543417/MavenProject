package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
	
	public WebDriver driver; //Created a selenium object for landing page

	By SignIn=By.id("nav-link-accountList"); //Over Sign In area on home page
	
	
	public AmazonHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement SignInTab() {
		
		return driver.findElement(SignIn);
	}
}

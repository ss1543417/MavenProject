package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MavenBase {
	
	public  WebDriver driver;//Defining driver variable globally
	public Properties mprop; //Defining gprop variable globally
	
	public WebDriver mvninitializedriver() throws IOException {
		
		mprop= new Properties(); //Object defined for properties class
		String mpath= System.getProperty("user.dir")+"/src/main/java/resources/data.properties"; //Assigning data.prop file path in gpath variable
		FileInputStream mfis= new FileInputStream(mpath); //Here FIS refering path of data.prop n assinging in its object gfis
		
		mprop.load(mfis); //Through this properties will refer data.prop path
		
		String browserName= mprop.getProperty("browser"); //We are extracting browser value from data.properties
		
		//execute in chromedriver
		
		if(browserName.equals("chrome")) { //As we are taking values from properties class so using .equals mtd
			
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse Coding\\Selenium Jar Files\\Drivers\\chromedriver.exe");
			 driver =new ChromeDriver(); //dEFINING object for chromedriver
			
			}
		
       else if(browserName.equals("firefox")) {
			
			//execute in firefox driver
			driver = new FirefoxDriver();
			
			
		}
		
      else if(browserName.equals("Microsoft Edge")) {
		
		//execute in Microsoft Edge driver
		
	}
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS); //This time wait applies for every test cases
		return driver;
		
			}
	
	public String getScreenShotPath(String ftestCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver; //Creating object for taking screenshot
		File source= ts.getScreenshotAs(OutputType.FILE); //Storing screenshot in a form of file
		String fdestinationFile= System.getProperty("user.dir")+"\\reports\\"+ftestCaseName+".png"; //This will save ss with tc name 
		FileUtils.copyFile(source,new File(fdestinationFile));//Copying ss file from source to file path provided 
		return fdestinationFile; //Returning path of fail ss
	}
	
	public String getScreenShotPathP(String ptestCaseName,WebDriver driver) throws IOException {
	
		TakesScreenshot ts=(TakesScreenshot) driver; //Creating object for taking screenshot
		File source= ts.getScreenshotAs(OutputType.FILE); //Storing screenshot in a form of file
		String pdestinationFile= System.getProperty("user.dir")+"\\reports\\"+ptestCaseName+".png"; //This will save ss with tc name 
		FileUtils.copyFile(source,new File(pdestinationFile));//Copying ss file from source to file path provided 
		return pdestinationFile; //Returning path of pass ss
	}
	
	
	

}

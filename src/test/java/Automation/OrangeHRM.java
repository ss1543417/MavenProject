package Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.MavenBase;

public class OrangeHRM extends MavenBase {
	
	public WebDriver driver; //Defining local driver to take properties from base class and execute cases in parallel
	
	public OrangeHRM oh; //Defining OrangeHRM page object globally to use in multiple test cases
	XSSFWorkbook workbook; //Defining object globally for XSSFWorkbook to use in any mtd
	int sheets; //Defining sheets globally to use in every methods
	//String a;
	
	//Identify Testcases column by scanning the entire 1st row
	//once column is identified then scan entire testcase column to identify login1 testcase row
	//after you grab login1 testcase row= pull all the datas of that row and feed into that test case
	
	@BeforeTest
	public void orangeLogin() throws IOException {
		
		driver=mvninitializedriver(); //Calling mvninitializedriver method in pagesNavigation method returning drive
		driver.get("https://opensource-demo.orangehrmlive.com/"); //Navigating to url provided
		driver.manage().window().maximize(); // Use to maximize the screen
		oh= new OrangeHRM(); //Creating OrangeHRM object to access its methods
		//fileInputStream argument
		
		FileInputStream fis= new FileInputStream("E://Eclipse Coding//Selenium Jar Files//MavenProject//orangeHRMdata.xlsx");
		//Passing excel file path to fis so that fis have access to read the file
		workbook=new XSSFWorkbook(fis); //Creating object for XSSFWorkbook to connect excel with java class
	    // As well as passing file path through fis  as an arguement
		sheets= workbook.getNumberOfSheets(); //Get the no. of sheets present in excel
		
	}
	
	@Test
	public void LoginPanel(String testcasename) {
		
		ArrayList<String> a=new ArrayList<String>(); //Creating arraylist to take data from excel
		
		for(int i=0;i<sheets;i++) { //To iterate through sheets present in excel
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) //If in iteration sheet name matches
			{
			XSSFSheet sheet=workbook.getSheetAt(i); //this represents page by page access on sheets in excel
			
			//Identify Testcases column by scanning the entire 1st row
			Iterator<Row> rows=sheet.iterator(); //rows have access to iterate every row of the sheet
			//sheet is collection of rows
			Row firstrow= rows.next(); //This will iterate to next row 
		    Iterator<Cell> ce=firstrow.cellIterator(); //This will iterate through each cell in a particular row
		    //row is collection of cells
		    int k=0; //This will represent column no.
		    int column = 0; 
		    while(ce.hasNext()) { //This will check whether next cell is present or not n it starts with 0th cell
		    	
		    	Cell value= ce.next(); //It will first reach in frst cell
		    	if(value.getStringCellValue().equalsIgnoreCase("Testcases")) { //This will grab cell value and compares with desired cell value
		    	 
		    		column=k; //when we found the desired column no. i.e index no. of column
		    		
		    		
		    	}k++; //If desired column not found the k will increment
		    }
		    System.out.println(column);
		    
		  //once column is identified then scan entire testcase column to identify login1 testcase row
		    while(rows.hasNext()) { //This will iterate through each row in a particular column
		    	
		    Row	r= rows.next(); //This will reach the row if present n storing in one variable
		    if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Login1")) {
			// Here we are getting cell of the column no. and grabing its value and then matching with desired value
			   
		   	//after you grab login1 testcase row= pull all the datas of that row and feed into that test case
		    Iterator<Cell> cv= r.cellIterator(); //This will store the data present in the cells of the row
		    while(cv.hasNext()) { //This will check next cell with value present or not
		    	
		    	a.add(cv.next().getStringCellValue()); //we are taking the values in arraylist
		    	
		   // String login1=cv.next().getStringCellValue(); //It will grab the cell value
		   // System.out.println(login1);
		    } 
		    }
		    	
		  }
		    /*while(rows.hasNext()) { //This will iterate through each row in a particular column
		    	Row  r= rows.next(); //This will reach the row if present n storing in one variable
		    if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Password")) {
				// Here we are getting cell of the column no. and grabing its value and then matching with desired value
				   
			   	//after you grab login1 testcase row= pull all the datas of that row and feed into that test case
			    Iterator<Cell> cp= r.cellIterator(); //This will store the data present in the cells of the row
			    while(cp.hasNext()) { //This will check next cell with value present or not
			    	
			    String password=cp.next().getStringCellValue(); //It will grab the cell value
			    System.out.println(password);
			    }
		   }
		    	
		    	
		    }*/
		    
		    
			
			
		}
		
	}
	
	
	

	}
}



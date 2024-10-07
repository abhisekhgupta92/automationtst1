package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



//import com.ltms.utility.excel_reader;
@Test
public  class BaseSetup {
	
	public static WebDriver driver;
	
	public static void LaunchBrowser() throws Exception {
	   
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Q846130\\workspace\\AutomationTest\\Chrome-exe\\chromedriver.exe");
		driver = new ChromeDriver();
		//SeleniumManager.getInstance();
		//driver.get("https://www.amazon.in/");
		
		driver.get(ExcelReader.getValue("baseUrl"));
		//driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
	
}
	
	public static void closeapplication() throws Exception{
		
		 driver.close();
	}
}
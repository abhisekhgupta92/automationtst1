package com.utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



//import com.ltms.utility.excel_reader;

public class BaseSetup {
	@Test
	public static void LaunchBrowser() throws Exception {
	   
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Q846130\\workspace\\AutomationTest\\Chrome-exe\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		//SeleniumManager.getInstance();
		//driver.get("https://www.amazon.in/");
		
		driver.get(ExcelReader.getValue("baseUrl"));
		//driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		
}	
}
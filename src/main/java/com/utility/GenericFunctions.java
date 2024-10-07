package com.utility;



import java.sql.Driver;
import java.time.Duration;

//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;
import com.utility.BaseSetup;
import org.openqa.selenium.WebDriver;


public class GenericFunctions extends BaseSetup {
	
	//public static Logger log = Logger.getLogger(GenericFunctions.class);
		//static WebDriver driver;
				
		
		
		
		public static void selectByVisibleText(String element, String VisibleText) {
			
			
			try {
				
				Select select = new Select(driver.findElement(By.xpath(element)));
				select.selectByVisibleText(VisibleText);
				//log.info("'Text'" + VisibleText+ "'is selected'");
				System.out.println("Element is selected");
			}
			catch (Exception e) {
				
				//log.error("'Text'" + VisibleText+ "'is not selected'");
			
		}

	}
		


	public static void clickOn(String locator) {
			
			
			
			try {
				
				driver.findElement(By.xpath(locator)).click();
				//log.info("'Element'" + locator+ "'is clickable'");
				System.out.println("Element is clicked");
			}
			catch (Exception e) {
				
				//log.error("'Element'" + locator+ "'is not clickable'");
			
		}

	}

	public static void WaitForElementPresent(WebDriver driver, String locator, Duration i) {
		
		
		
	try {
			
WebDriverWait wait = new WebDriverWait(driver, i);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
//textToBePresentInElement(element, expectedText));
System.out.println("ExplictWaitof 20 seconds");
		}
		catch (Exception e) {
			
			//log.error("'Element'" + locator+ "'is not clickable'");
		
	}



	}


	}
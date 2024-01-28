package Testing;

import java.io.File;
import java.sql.Date;
import java.util.concurrent.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utlity.BaseSetup;

public class FunctionalTest {
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;

	//XPATH
	public String Search_Button= "//div[@class='nav-search-submit nav-sprite']";


	    @BeforeTest
	    public void SetReport()
	    {
	    	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
	    	extent.addSystemInfo("Host Name", "Dell Laptop");
	    	extent.addSystemInfo("User Name", "Gupta, Abhisekh EX1");
	    	extent.addSystemInfo("OS", "Windows 10");
	    	extent.addSystemInfo("Browser", "Chrome");
	    	extent.addSystemInfo("Enviornment", "Testing-QA");
	    }

		@AfterTest
		public void endreport(){
			
			extent.flush();
			extent.close();
		}

		public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
		
		@SuppressWarnings("deprecation")
		@BeforeMethod
		public void OpenBrowser() throws Exception{
		
			BaseSetup.LaunchBrowser();
		
		}
		
		@Test
		
		public void AmazonTitleTest(){
			
			logger = extent.startTest("AmazonTitleTest");
			String Title = driver.getTitle();
			
			System.out.print("Title");
			
			Assert.assertEquals(Title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
			
			
			
		}
		
		@Test
		public void selectProduct(){
			logger = extent.startTest("AmazonSelectProductTest");
			WebElement category = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
			//category.click();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Select select = new Select(category);
			//select.selectByValue("Electronics");
			select.selectByVisibleText("Electronics");
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath(Search_Button)).click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement category1 = driver.findElement(By.xpath("//div/h2[text()='New  & trending: Laptops']"));
		    js.executeScript("arguments[0].scrollIntoView(true);", category1);
		    System.out.println(category1.getText());
		    try{Thread.sleep(3000);}
		    catch(InterruptedException e)
		    {System.out.println(e);}    
		        
		  }  
		
		
		
		@AfterMethod
		
		public void teardown (ITestResult result)throws Exception
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
			logger.log(LogStatus.FAIL, "Step 1: Verify Amazon Title on Home Page", "Amazon Title is not verified on Home Page");
			//String screenshotpath = TestReport.getScreenhot(driver, result.getName());
			//logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotpath));
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				//logger.log(LogStatus.PASS, "Amazon Title is matching");
				//String screenshotpath = TestReport.getScreenhot(driver, result.getName());
				logger.log(LogStatus.PASS, "Step 1: Verify Amazon Title on Home Page", "Verified Amazon Title on Home Page");
				//logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotpath));
			}
			
			extent.endTest(logger);
			driver.quit();
		}






}

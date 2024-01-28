package AutomationTest.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utlity.*;
import com.utlity.BaseSetup;

public class TestPOM extends BaseSetup {
	
	WebDriver driver;
	
	By UserName_text = By.name("WebPatterns_wt6$block$wtUsername$wtUserNameInput");
	By Password_text = By.name("WebPatterns_wt6$block$wtPassword$wtPasswordInput");
	By Login_Buttom = By.id("WebPatterns_wt6_block_wtAction_wtLoginButton");
	By MenuIcon = By.className("White App_Menu_Balloon");
	By TestDirLink = By.xpath("//a[text()='Test Directory']");
	By Searchbox = By.xpath("*//select[@id='searchDropdownBox']");
	By Searchtextbox = By.xpath("*//input[@id='twotabsearchtextbox']");
	By Searchbtn = By.xpath("*//input[@id='nav-search-submit-button']");

	
	
	
	public TestPOM(WebDriver driver){
		//this.driver=driver;
	}
	
	
	
	
	
	
	
	public void SettextUserName(String UserName){
		driver.findElement(UserName_text).sendKeys(UserName);
		
	}
	
	public void entersearchtext(String text){
		driver.findElement(Searchtextbox).sendKeys(text);
		
	}
	
	
	public void ClickLoginbtn(){
		driver.findElement(Login_Buttom).click();
		
	}
	
	public void ClickSelectbtn(){
		driver.findElement(Searchbox).click();
		
	}
	public void ClickSearchbutton(){
		driver.findElement(Searchbtn).click();
		
	}
	
	public void ClickTestDirLink(){
		driver.findElement(TestDirLink).click();
		
	}

}


package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class OpenBrowser {

	public static WebDriver driver;
	@Test
	public static void log(){
		 //WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\workspace\\AutomationTest\\Chrome-exe\\chromedriver-win64\\chromedriver.exe");
	 driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
}
}
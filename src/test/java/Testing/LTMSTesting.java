package Testing;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utlity.BaseSetup;

import AutomationTest.PageObject.TestPOM;

public class LTMSTesting extends BaseSetup {
	public WebDriver driver;
	public static String StepDetail;
	public static String Actual;
	public String TestCaseID = this.getClass().getSimpleName();
	TestPOM Selectdropbtn = new TestPOM(driver);
	//String text = data.get("TestCaseID").toString();

	@Test(dataProvider = "getData")
	public void LTMS_Test(Map<Object, Object> data) throws Exception{
		BaseSetup.LaunchBrowser();
		System.out.println("-------------Test case started ----------------");
		//WebDriverWait wait = new WebDriverWait(driver,30);
		 
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("*//select[@id='searchDropdownBox']")));
	//ExtentTest logger = extent.createTest("CreateAnalyte", "Create Analyte Test");
 		
 		
 		StepDetail = "Open Amazon home page";
 		try {
 		
 		Selectdropbtn.ClickSelectbtn();
 		
 		Selectdropbtn.entersearchtext((String) data.get("TestCaseID"));
 		
 		Selectdropbtn.ClickSearchbutton();
 		
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		
	    
	
	    
	    StepDetail = "Log into LTMS as an Authorized User using personal QID and network password.";
		Actual = "Authorized User with name as Firstname and Lastname displayed in upper right corner of the CTMS landing/home page.";
    	    System.out.println("Test case Name is" + data.get("TestCaseID"));
    	    System.out.println("Enviornmrnt is:" + data.get("Environment"));
    	    System.out.println(data.get("LabSystem(QLS/ULTRA)"));

    	    System.out.println("-------------Test case Ended ----------------");

    	  
 }
    	
    	
    	
    @DataProvider(name = "getData")
    public Object[][] dataSupplier() throws Exception {

      File file = new File("C://Users//Q846130//OneDrive - IQVIA//Desktop//EAF//Test_Data.xlsx");
      FileInputStream fis = new FileInputStream(file);

      XSSFWorkbook wb = new XSSFWorkbook(fis);
      //XSSFSheet sheet = wb.getSheetAt(0);
      XSSFSheet sheet = wb.getSheet(TestCaseID);
      wb.close();
      int lastRowNum = sheet.getLastRowNum() ;
      int lastCellNum = sheet.getRow(0).getLastCellNum();
      Object[][] obj = new Object[lastRowNum][1];

      for (int i = 0; i < lastRowNum; i++) {
        Map<Object, Object> datamap = new HashMap<Object, Object>();
        for (int j = 0; j < lastCellNum; j++) {
          datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
        }
        
       
        obj[i][0] = datamap;

      }
      return  obj;
    }

  }



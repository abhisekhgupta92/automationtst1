package Testing;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utlity.DataReader;
import com.utlity.BaseSetup;;

public class LTMSTest extends BaseSetup {
	
	//ExtentHtmlReporter Report;
	//ExtentReports extent;
	String TestCaseName = this.getClass().getSimpleName();
	String StepDetail;
	String Actual;
	
	//double TestCaseStartTime = '0';
	
	
	
	
//   public  void preRequisite_Setup() {
//		
		
//		TestCaseStartTime = System.currentTimeMillis();
//		
//		
//		Report = new ExtentHtmlReporter("Extent.html");
//		
//		extent = new ExtentReports();
//		extent.attachReporter(Report);
//		
//			
//		}   
    @Test(dataProvider = "getData")
	public void LTMS_Receive_Samples_Test(Map<String, String> data) throws Exception{

    	    System.out.println("-------------Test case started ----------------");
    	    //ExtentTest logger = extent.createTest("CreateAnalyte", "Create Analyte Test");
     		
    	    BaseSetup.LaunchBrowser();
    	    
    	    StepDetail = "Log into LTMS as an Authorized User using personal QID and network password.";
			Actual = "Authorized User with name as Firstname and Lastname displayed in upper right corner of the CTMS landing/home page.";
    	    
    	    System.out.println(data.get("TestCaseID"));
    	    System.out.println(data.get("Environment"));
    	    System.out.println(data.get("LabSystem"));

    	    System.out.println("-------------Test case Ended ----------------");

    	  

    	
    	
    	
    	
    	
//    	TestDirectoryPOM TestDirObj = new TestDirectoryPOM(driver);
//		ExtentTest logger = extent.createTest("CreateAnalyte", "Create Analyte Test");
//		BaseSetup.LaunchBrowser();
//		// Launch LTMS application
//		driver.get("http://morsltftw01q.quintiles.net/QSquaredTheme_Q2/Login.aspx");
//		logger.info("Launch LTMS Application");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	
//		TestDirObj.SettextUserName("Q846130");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		TestDirObj.SettextPassword("Health@07");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		TestDirObj.ClickLoginbtn();
//		logger.pass("Login Successfull");
//		
//		//Navigate to Test Directory screen
//		TestDirObj.ClickMenuIcon();
//		TestDirObj.ClickTestDirLink();
//		
//		//logger.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());
//        
//		
//		extent.flush();
    }
		
    @DataProvider(name = "getData")
    public Object[][] getExceData() throws Exception{
      return com.utlity.DataReader.getExceData(TestCaseName); 
      	
	}

  }

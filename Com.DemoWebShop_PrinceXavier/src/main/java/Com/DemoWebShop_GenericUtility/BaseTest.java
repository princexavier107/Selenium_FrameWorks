package Com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_Page;
import Com.DemoWebShop_POM.Login_Page;
import Com.DemoWebShop_POM.Welcome_Page;

public class BaseTest {
	

	public WebDriver driver;
	static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileUtility = new FileUtility();
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriver_Utility webDriverUtility = new WebDriver_Utility();
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite --- DataBase Connection");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test --- Report Generation");
		spark = new ExtentSparkReporter(FrameWorkContants.reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("DemoWebShop");
		
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before Class --- Launch Browser");
		
		String browser = fileUtility.readDataFromPropertyFile("browserName");
		String url = fileUtility.readDataFromPropertyFile("url");
		
//		String browser = System.getProperty("browserName");
//		String url = System.getProperty("baseUrl");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Running testing on chrome browser");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Running testing on firefox browser");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Running testing on edge browser");
			driver = new EdgeDriver();
		} else {
			System.out.println("Pass the correct browser Name: " + browser);
		}
		
		sDriver = driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Navigate to the website
		driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Before Method --- Login to app");
		
		//Welcome page
		welcomePage = new Welcome_Page(driver);
		welcomePage.getLoginBtn().click();
		
		//Login Page
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();
		
		//Home Page
		homePage = new Home_Page(driver);
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("After Method ---- Logout from app");
	}
	
	@AfterClass
	public void AfterClass() throws InterruptedException {
		System.out.println("After Class --- Browser closed");
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("After Test --- Report generated");

	}
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("After Suite --- Database connection is terminated");

	}
	
	
	
	
	

}


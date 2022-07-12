package Main_test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Datautils.Report_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_test {
	protected WebDriver driver;
	public static String folder_path_extentreport;
	public static String extentreport_execution_folderpath;
	public static String screenshot_folderpath;
	static String screenshot_path= null;
	static ExtentTest test = null;
	static ExtentReports report = null;
	
	
	
	
	@BeforeSuite
	public void extent_report() {
		
		//we are creating folders in our current directory.
		folder_path_extentreport = System.getProperty("user.dir") + "\\report_of_extenttest\\";
		extentreport_execution_folderpath =Report_utility.main_Folder_Creation(folder_path_extentreport);
		screenshot_folderpath = Report_utility.screenshot_folder_creation(extentreport_execution_folderpath);
		
		//Extent report is created here
		ExtentSparkReporter  extent_report = new ExtentSparkReporter(extentreport_execution_folderpath + "\\flight_report_file.html");
		extent_report.config().setDocumentTitle("Makemytrip_automation");
		extent_report.config().setReportName("automation");
		extent_report.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(extent_report);
		
	

		
		
		
	}
	
	
	@AfterSuite
	public void extent_end() {
		report.flush();
		
	}
	
	
	@BeforeTest
	public void launchapp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
	}
	
	
	@AfterTest
	
	public void closeapp() throws Exception {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File targetLocation = new File("F:\\screenshot\\demo.png");

		FileUtils.copyFile(screenshotFile, targetLocation);
		report.flush();
		driver.quit();
		
	}
	
	



}

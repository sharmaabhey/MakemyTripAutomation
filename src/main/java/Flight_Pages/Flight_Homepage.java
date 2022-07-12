package Flight_Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Datautils.Report_utility;

public class Flight_Homepage {

	WebDriver driver;
	ExtentTest reporter;
	
	By fromcity = By.xpath("//label[@for='fromCity']");
	By st = By.xpath("//span[@class='langCardClose']");
	By fromc = By.xpath("//input[@placeholder='From']");
	By too = By.xpath("//input[@placeholder='To']");
	By date = By.xpath("//p[text()='''+ s +''']");
	By searching = By.xpath("//a[text()='Search']");
	By types_of_facilities = By.xpath("//ul[@class='makeFlex font12']//child::a[@class='makeFlex hrtlCenter column']//following-sibling::span");

	public Flight_Homepage(WebDriver driver, ExtentTest reporter) {
		this.driver = driver;
		this.reporter= reporter;

	}
	
	public void Types_of_facilities(String choose) {
		List<WebElement> Types = driver.findElements(types_of_facilities);
		
		for(WebElement web : Types) {
			String choice = web.getText();
			if(choice.equals(choose)) {
				web.click();
				break;
			}
			
		}System.out.println(choose);
		
	}

	public void page_validation() {
		// Boolean page_display =driver.findElement(By.xpath("//img[@alt='Make My
		// Trip']")).isDisplayed();
		// Assert.assertTrue(true);
		String my_title = driver.getTitle();
		System.out.println("Title of the page is:" + my_title);
		String xpath = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		Assert.assertEquals(my_title, xpath);

	}



	

	

	// it cancel the first popup
	public void cancelingpopup() {
//		driver.findElement(fromcity).click();

		driver.findElement(st).click();
		reporter.pass("Canceling popup");

	}
	
	
	public void selecting_type_of_flight(String Type) {

		List<WebElement> selecting = driver.findElements(By.xpath("//ul[@class='fswTabs latoBlack greyText']//child::li"));
		for (WebElement ele : selecting) {
			String choice = ele.getText();
			if (choice.equals(Type)) {
				ele.click();
				
				break;
			}
		}
		System.out.println(Type);
		reporter.pass("Entered flight type is:"+ Type);

	}
	
	public void click_on_from() throws Exception {
		driver.findElement(fromcity).click();
		reporter.pass("Homepage screenshot of clicking on from location:" , MediaEntityBuilder.createScreenCaptureFromPath(Report_utility.captureSS(driver)).build());
		
	}

	// it is for choosing starting location
	public void from(String from) throws Exception {
		
		WebElement bgb = driver.findElement(fromc);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(bgb));
		bgb.click();
		Thread.sleep(1000);
		bgb.sendKeys(from);
		Thread.sleep(2000);
		bgb.sendKeys(Keys.ARROW_DOWN);
		bgb.sendKeys(Keys.ENTER);
		
		reporter.pass("The entered value for departing place is:" + from);
		
	}

	// it is for choosing final destination
	public void to(String to) throws Exception {
		WebElement be = driver.findElement(too);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(be));
		be.click();
		Thread.sleep(1000);
		be.sendKeys(to);
		Thread.sleep(2000);
		be.sendKeys(Keys.ARROW_DOWN);
		be.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		reporter.pass("The enetered value for destination place is:" + to);
	}

	// it is for setting up the date
	public void Setdate(String s) throws Exception {
		String get_month = driver.findElement(By.xpath("(//div[@role='heading'])[2]")).getText();
		System.out.println(get_month);
		Thread.sleep(2000);
		String date = s;
		String splitter[] = date.split(",");
		String day = splitter[0];
		System.out.println(day);
		String monthandyear = splitter[1];
		System.out.println(monthandyear);
		while (!get_month.equals(monthandyear)) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			Thread.sleep(3000);
			get_month = driver.findElement(By.xpath("(//div[@role='heading'])[2]")).getText();

			System.out.println(get_month);
		}

		String xpath = "(//div[@class='DayPicker-wrapper']//div[@class='DayPicker-Month'])[2]//div[@class='DayPicker-Day']//following::p[text()='"+ day + "']";
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);
		reporter.pass("Entered date of flying is:" + s);

	}
	
	
	public void Rounttrip_departure_date(String depart_date) throws Exception {
		
		String get_month = driver.findElement(By.xpath("(//div[@role='heading'])[1]")).getText();
		System.out.println(get_month);
		Thread.sleep(2000);
		String date = depart_date;
		String splitter[]= date.split(",");
		String day = splitter[0];
		System.out.println(day);
	    String monthandyear =splitter[1];
		System.out.println(monthandyear);
		while(!get_month.equals(monthandyear)) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		Thread.sleep(3000);
			get_month = driver.findElement(By.xpath("(//div[@role='heading'])[1]")).getText();
			
			System.out.println(get_month);
	}
		
		String xpath = "(//div[@class='DayPicker-wrapper']//div[@class='DayPicker-Month'])[1]//following::div[@class='DayPicker-Body']//following::p[text()='"+day+"']";
		//System.out.println(xpath);
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);
		reporter.pass("Entered depart date is:" + depart_date);
	
		
	}
	
	
	public void return_date(String dte) throws Exception  {
		String get_month = driver.findElement(By.xpath("(//div[@role='heading'])[1]")).getText();
		System.out.println(get_month);
		Thread.sleep(2000);
		String date = dte;
		String splitter[]= date.split(",");
		String day = splitter[0];
		System.out.println(day);
	    String monthandyear =splitter[1];
		System.out.println(monthandyear);
		while(!get_month.equals(monthandyear)) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		Thread.sleep(3000);
			get_month = driver.findElement(By.xpath("(//div[@role='heading'])[1]")).getText();
			
			System.out.println(get_month);
	}
		
		String xpath = "((//div[@class='DayPicker-wrapper']//div[@class='DayPicker-Month'])[1]//div[@class='DayPicker-Day']//following::p[text()='"+day+"'])[1]";
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);
		reporter.pass("entered return date for round trip is:" + dte);
	

	 }

	// this method helps to click on search button
	public void search() {
		driver.findElement(searching).click();
		reporter.pass("clicking on search button");	
		}
}

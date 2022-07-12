package Hotel_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Datautils.Report_utility;

public class Hotel_homepage {
	WebDriver driver;
	ExtentTest reporter;
	By click_city = By.xpath("//input[@id='city']");
	By Hotel_city = By.xpath("//input[@autocomplete='nope']");
//	By click_on_checkindate = By.xpath("(//span[@class='lbl_input latoBold appendBottom5'])[1]");
//	By click_on_checkoutdate = By.xpath("(//span[@class='lbl_input latoBold appendBottom5'])[2]");
	By searching = By.xpath("//button[text()='Search']");
	By Hotels = By.xpath("(//a[@class='makeFlex hrtlCenter column'])[1]");
	
	public Hotel_homepage(WebDriver driver , ExtentTest reporter) {
		this.driver =  driver;
		this.reporter = reporter;
	}
	
//	public void click_hotels() throws Exception {
//		driver.findElement(Hotels).click();
//		Thread.sleep(2000);
//		reporter.pass("Click on hotels");
//		
//		
//		
//		
//	}
	
	
	public void click_on_city() throws Exception {
		WebElement ele = driver.findElement(click_city);
		ele.click();
		Thread.sleep(2000);
		
		reporter.pass("clicking on city");
		
	}
	
	
	public void Select_city(String city) throws Exception {
		WebElement web = driver.findElement(Hotel_city);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(web));
		web.click();
		web.sendKeys(city);
		Thread.sleep(2000);
		web.sendKeys(Keys.ARROW_DOWN);
		web.sendKeys(Keys.ENTER);
		reporter.pass("Selected city is:" + city);
		
		
	}
	
	
//	public void click_on_checkin() throws Exception {
//		WebElement checkin = driver.findElement(click_on_checkindate);
//		checkin.click();
//		Thread.sleep(2000);
//	}
	
	
	public void Select_date(String date) throws Exception {
		String get_month = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
		System.out.println(get_month);
		Thread.sleep(2000);
		String choosing_date = date;
		String splitter[]= date.split(",");
		String day = splitter[0];
		System.out.println(day);
	    String monthandyear =splitter[1];
		System.out.println(monthandyear);
		while(!get_month.equals(monthandyear)) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		Thread.sleep(3000);
			get_month = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
			
			System.out.println(get_month);
	}
		
		String xpath = "(//div[@class='DayPicker-wrapper']//div[@class='DayPicker-Month'])[1]//div[text()='"+day+"']";
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);
		reporter.pass("Entered check-in date is:" + date);
	
		
	}
//	public void click_on_checkout() {
//		WebElement checkout = driver.findElement(click_on_checkoutdate);
//		checkout.click();
//	}
	
	
	public void select_checkout_date(String checkout_date) throws Exception {
		
		String get_month = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
		System.out.println(get_month);
		Thread.sleep(2000);
		String click_on_date= checkout_date;
		String splitter[]= checkout_date.split(",");
		String day = splitter[0];
		System.out.println(day);
	    String monthandyear =splitter[1];
		System.out.println(monthandyear);
		while(!get_month.equals(monthandyear)) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		Thread.sleep(3000);
			get_month = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
			
			System.out.println(get_month);
	}
		
		String xpath = "(//div[@class='DayPicker-wrapper']//div[@class='DayPicker-Month'])[1]//div[text()='"+day+"']";
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);
		reporter.pass("Hotel homepage screenshot:" , MediaEntityBuilder.createScreenCaptureFromPath(Report_utility.captureSS(driver)).build());
		reporter.pass("Entered check-out date os:" + checkout_date);
	
		
	}
	
	public void search() {
		driver.findElement(searching).click();
		reporter.pass("clicking on search button");
	
	
	
}
}

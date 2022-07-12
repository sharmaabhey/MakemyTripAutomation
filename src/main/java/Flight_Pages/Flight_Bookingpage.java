package Flight_Pages;

import org.apache.tools.ant.types.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Datautils.Report_utility;


public class Flight_Bookingpage {
	
	
	WebDriver driver;
	ExtentTest reporter;
	By cancel = By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']");
	By ns =By.xpath("//span[text()='Non Stop']");
	By pop =By.xpath("//button[text()='OKAY, GOT IT!']");
	By view_price=By.xpath("//span[text()='View Prices']");
	By Book_now=By.xpath("//button[text()='Book Now']");
	By continue_click = By.xpath("//button[text()='Continue']");
		
		public Flight_Bookingpage(WebDriver driver, ExtentTest reporter) {
			this.driver=driver;
			this.reporter = reporter;
			
		}
		
		
		public void booking_page_validation() {
			String heading = driver.getTitle();
			System.out.println(heading);
			
		}
		
		
		public void cancelalert() throws Exception {
			
			
			
			try {
				
				WebElement popup=driver.findElement(pop);
				Thread.sleep(2000);
				if (popup.isDisplayed()) {
					popup.click();
				}
				
			}catch(Exception ne) {
				System.out.println("There is no alert");
			}
			reporter.pass("Booking page screenshot:" , MediaEntityBuilder.createScreenCaptureFromPath(Report_utility.captureSS(driver)).build());
			reporter.pass("Canceling the random alert");
			
		
			
		
		}
		//choosing non stop flights
		public void nonstop() throws Exception {
			
			
			driver.findElement(ns).click();
			Thread.sleep(2000);
			reporter.pass("Booking page screenshot of selecting non_stop flights:" , MediaEntityBuilder.createScreenCaptureFromPath(Report_utility.captureSS(driver)).build());
		}
		//By this method it view the price of ticket and the book that
		public void  viewpriceandbook() throws Exception {
			try {
				WebElement price_view = driver.findElement(view_price);
				Thread.sleep(2000);
				if(price_view.isDisplayed()) {
					price_view.click();
				
			}
			}catch(Exception ne) {
				System.out.println("there is no option for viewing the price");
			}
			reporter.pass("Viewing price and book the tickets");
			
		
		
			String oldwin = driver.getWindowHandle();  
			
			driver.findElement(Book_now).click();
			try {
				WebElement click_continue = driver.findElement(continue_click);
				Thread.sleep(2000);
				if(click_continue.isDisplayed()) {
					click_continue.click();
				}
			}catch(Exception ne) {
				System.out.println("Sorry, there is continue button");
			}
			Thread.sleep(2000);
			for (String currwin: driver.getWindowHandles()) {
				if (oldwin != currwin) {
					driver.switchTo().window(currwin);
					
				}
			}
			
		}


}

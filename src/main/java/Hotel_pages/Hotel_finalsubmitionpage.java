package Hotel_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Datautils.Report_utility;

public class Hotel_finalsubmitionpage {
	
	WebDriver driver;
	ExtentTest reporter;
	By Amount_tobe_paid = By.xpath("//p[text()='Total Amount to be paid']//following::div[@class='prcBreakup__rht']//child::p");
	By upgrade_stay = By.xpath("(//p[contains(text(),'Upgrade Your Stay')]//following-sibling::ul[@class='upgdStay__list']//child::li)[1]");
	By book_room = By.xpath("//button[text()='BOOK THIS NOW']");
	
	public Hotel_finalsubmitionpage(WebDriver driver,ExtentTest reporter) {
		this.driver= driver;
		this.reporter= reporter;
	}
	
	public void booking_room() throws Exception {
		driver.findElement(book_room).click();
		Thread.sleep(3000);
		reporter.pass("Booking the rooms");
	}

	
	public void taking_price() throws Exception {
		String total_amount = driver.findElement(Amount_tobe_paid).getText();
		String str = total_amount.replace(",", "");
		String new_str = str.replace("₹ ", "");
		int num = Integer.parseInt(new_str);
		System.out.println(num);
		driver.findElement(upgrade_stay).click();
		Thread.sleep(2000);
		reporter.pass("Final submit page scrrenshot:" , MediaEntityBuilder.createScreenCaptureFromPath(Report_utility.captureSS(driver)).build());
		

	}
	
//	public void Upgrade_your_stay() throws Exception {
//		driver.findElement(upgrade_stay).click();
//		Thread.sleep(2000);
//	}

}

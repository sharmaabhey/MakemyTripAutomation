package Hotel_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Datautils.Report_utility;

public class Hotel_bookingoage {
	
	WebDriver driver;
	ExtentTest reporter;
	By star_path = By.xpath("//div[contains(@id , 'STAR_CATEGORY')]//child::div[@class='makeFlex hrtlCenter']//child::span");
//	By Star5 = By.xpath("(//ul[@class='filterList'])[2]//following::span");
//	By star4 =By.xpath("(//ul[@class='filterList'])[2]//following::span[text()='4 Star']");
//	By star3 = By.xpath("(//ul[@class='filterList'])[2]//following::span[text()='3 Star']");
	By click_show_18_more = By.xpath("//div[text()='Amenities']//following::span[text()='Show 18 more']");
	By choosing_amenities= By.xpath("//div[contains(@id,'AMENITIES')]//child::ul[@class='filterList']//child::label");
	By choosing_rooms = By.xpath("(//div[@class='flexOne makeFlex'])[1]");
	By recommended_tag = By.xpath("//p[text()='Recommended for You']");
	
	public  Hotel_bookingoage(WebDriver driver, ExtentTest reporter) {
		this.driver = driver;
		this.reporter = reporter;
	}
	
	public void stars_category(String star) throws Exception {
		
		List <WebElement> ele = driver.findElements(star_path);
		System.out.println(ele.size());
		for (WebElement element : ele ) {
			String options = element.getText();
			String str = star;
			String[] Splitter= str.split(",");
			for(String add : Splitter) {
				String store = add;
				System.out.println(store);
				if(options.contains(store)) {
					
					element.click();
//					System.out.println("yes");
					
					WebDriverWait wait = new WebDriverWait(driver,60);
					wait.until(ExpectedConditions.visibilityOfElementLocated(recommended_tag));
					break;
				}
				
			}
			
			
		}reporter.pass("Hotel bookingepage screenshot :" , MediaEntityBuilder.createScreenCaptureFromPath(Report_utility.captureSS(driver)).build());
		reporter.pass("Emtered stars category are:" + star);
		
	
	}
	
	
	public void choosing_amenities(String amenity) throws Exception {
		driver.findElement(click_show_18_more).click();
		List<WebElement> click_options = driver.findElements(choosing_amenities);
		System.out.println(click_options.size());
		for(WebElement ele: click_options) {
			String options = ele.getText();
			String saving_amenity = amenity;
			String[] Splitter = saving_amenity.split(",");
			for(String str : Splitter) {
				String store = str;
				if(options.contains(store)) {
					ele.click();
					Thread.sleep(5000);
					break;
				}
			}
		}reporter.pass("Entered amenities are:" + amenity);
		
		
	}
	
	
	public void choosing_hotel_rooms() throws Exception {
		driver.findElement(choosing_rooms).click();
		System.out.println("yes it is clicking");
		String old_window= driver.getWindowHandle();
		for (String currwin: driver.getWindowHandles()) {
			if (old_window != currwin) {
				driver.switchTo().window(currwin);
				
			}
		}
		
		Thread.sleep(2000);
		
		reporter.pass("choosing hotel rooms:");
	}
	

}

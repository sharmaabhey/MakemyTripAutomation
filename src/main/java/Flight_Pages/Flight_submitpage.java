package Flight_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class Flight_submitpage {
	
	WebDriver driver;
	ExtentTest reporter;
	By mobi = By.xpath("//input[@placeholder='Mobile No']");
	By mail = By.xpath("//input[@placeholder='Email']");
	By promo =By.xpath("//span[text()='MMTSUPER']");
	By secure = By.xpath("//b[text()='Yes, Secure my trip. ']");
	
	
	
	public Flight_submitpage(WebDriver driver, ExtentTest reporter) {
		this .driver=driver;
		this.reporter = reporter;
	}
	

	public void promocode() {
		WebElement ele = driver.findElement(promo);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}
	
	/*public void securetrip() throws Exception{
		
		//driver.findElement(By.xpath("//input[@class='pointer']//following::div[@class='flexOne']//child::font[text()='Add Free Date Change']")).click();
	
		try {
			WebElement secure_trip = driver.findElement(secure);
			Thread.sleep(2000);
			
			if(secure_trip.isDisplayed()) {
				secure_trip.click();
			}
			
		}catch(Exception ne) {
			System.out.println("there no any secure trip option");
		}
	}*/
		
	/*public void add_free() {
		driver.findElement(By.xpath("//input[@class='pointer']")).click();
		}*/
	
	
	public void price() throws Exception {
		
		String total_amount= driver.findElement(By.xpath("//span[text()='Total Amount']//following-sibling::span")).getText();
		String str = total_amount.replace(",", "");
		String new_str = str.replace("₹ ", "");
		int base_amount = Integer.parseInt(new_str);
		//System.out.println(num);
		
		
		try {
			WebElement secure_trip = driver.findElement(secure);
			Thread.sleep(2000);
			
			if(secure_trip.isDisplayed()) {
				secure_trip.click();
			}
			
		}catch(Exception ne) {
			System.out.println("there no any secure trip option");
		}
		
		//driver.findElement(By.xpath("(//span[@class='iconPlusImg bgProperties'])[3]")).click();
		Thread.sleep(2000);
		String insurance = driver.findElement(By.xpath("//span[text()='Insurance']//following-sibling::span")).getText();
		String removing = insurance.replace("₹ ", "");
		int insurance_cost = Integer.parseInt(removing);
		System.out.println(insurance_cost);
//		driver.findElement(By.xpath("//input[@class='pointer']//following::div[@class='flexOne']//child::font[text()='Add Free Date Change']"));
		/*String Free_date_change = driver.findElement(By.xpath("//span[text()='Free Date Change']//following::span[text()='₹ 235']")).getText();
		String delete_ruppeysign = Free_date_change.replace("₹", "");
		int free_datechange = Integer.parseInt(delete_ruppeysign);
		System.out.println(free_datechange);*/
		int Final_amount =  insurance_cost + base_amount ;
		
		
    	Assert.assertNotEquals(base_amount, Final_amount);
    	System.out.println("the intial amount and final amount is not same");
    	reporter.pass("Checking the intial price and final price equal or not");
    	
//		System.out.println("total amount and final amount is not same");
		
	}
	
	
	
	
	
	 public void scroll() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  
			
			WebElement web = driver.findElement(By.xpath("//input[@placeholder='Mobile No']"));
			
			js.executeScript("arguments[0].scrollIntoView();", web);
			reporter.pass("scrolling to the details");
	 }
	 
	 public void  mobilenumber(String mobilenumber) {
		 WebElement mob = driver.findElement(mobi);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(mob));
		 
		 mob.sendKeys(mobilenumber);
		 reporter.pass("Entered mobile number is:" + mobilenumber);
	 }
	 
	 public void email(String email) {
		 WebElement E = driver.findElement(mail);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(E));
		 E.sendKeys(email);
		 reporter.pass("Entered Email is:" + email);
	 }


}

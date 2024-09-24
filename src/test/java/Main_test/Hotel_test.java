package Main_test;

import java.util.Map;

import org.testng.annotations.Test;

import Datautils.Data_Supplier;
import Hotel_pages.Hotel_bookingoage;
import Hotel_pages.Hotel_homepage;

public class Hotel_test extends Base_test {
	
	
	@Test(dataProvider="Flight_data" , dataProviderClass= Data_Supplier.class)
	
	public void testing_hotel_code(Map hotelobj) throws Exception {
//		Hotel_homepage home_page = new Hotel_homepage(driver);
//		home_page.click_hotels();
//		home_page.click_on_city();
//		home_page.Select_city((String) hotelobj.get("Hotel_City"));
//		//home_page.click_on_checkin();
//		home_page.Select_date((String) hotelobj.get("checkin"));
//		//home_page.click_on_checkout();
//		home_page.select_checkout_date((String) hotelobj.get("checkout"));
//		home_page.search();
//		
//		
//		
//		Hotel_bookingoage booking_page = new Hotel_bookingoage(driver);
//		booking_page.stars_category((String) hotelobj.get("Star_category"));
//		
		
	}
	
	

}

package Main_test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Datautils.Data_Supplier;
import Flight_Pages.Flight_Bookingpage;
import Flight_Pages.Flight_Homepage;
import Flight_Pages.Flight_submitpage;
import Hotel_pages.Hotel_bookingoage;
import Hotel_pages.Hotel_finalsubmitionpage;
import Hotel_pages.Hotel_homepage;

public class Main_test_with_Dataprovider extends Base_test {
	
	
	
	
	@Test(dataProvider="Flight_data" , dataProviderClass= Data_Supplier.class)
	
	public void Booking_tickets(Map Flightobj) throws Exception{
		test = report.createTest((String) Flightobj.get("Test_CaseName"));
		
		
		
	  
		
		
		Flight_Homepage Home_page= new Flight_Homepage(driver,test);
		Home_page.page_validation();
		Home_page.cancelingpopup();
		//I applied a condition  here for choosing Flight or hotels
		Home_page.Types_of_facilities((String) Flightobj.get("Types_of_facility"));
		String choosing_facility = (String) Flightobj.get("Types_of_facility");
		System.out.println(choosing_facility);
		
		//If statement contains the  flow of hotel
		if(choosing_facility.equals("Hotels")) {
			Hotel_homepage home_page =new Hotel_homepage(driver,test);
			//home_page.click_hotels();
			home_page.click_on_city();
			home_page.Select_city((String) Flightobj.get("Hotel_City"));
			home_page.Select_date((String) Flightobj.get("checkin"));
			home_page.select_checkout_date((String)Flightobj.get("checkout"));
			home_page.search();
			
			Hotel_bookingoage booking_page = new Hotel_bookingoage(driver,test);
			booking_page.stars_category((String) Flightobj.get("Star_category"));
			booking_page.choosing_amenities((String) Flightobj.get("Amenity"));
			booking_page.choosing_hotel_rooms();
			
			Hotel_finalsubmitionpage submit_page = new Hotel_finalsubmitionpage(driver,test);
			submit_page.booking_room();
			submit_page.taking_price();
			//submit_page.Upgrade_your_stay();
		}else {
			
		
		
		
		
		Home_page.selecting_type_of_flight((String) Flightobj.get("Type_of_flight"));
		
		Home_page.click_on_from();
		
	
		Home_page.from((String) Flightobj.get("From"));
		Home_page.to((String)Flightobj.get("To"));
		String selecting_type = (String) Flightobj.get("Type_of_flight");
		if(selecting_type.equals("OneWay")) {
			Home_page.Setdate((String) Flightobj.get("Departure"));
	     
			
		//else contains the flow of flights
		}else {
			Home_page.Rounttrip_departure_date((String) Flightobj.get("Departure_date"));
			Home_page.return_date((String) Flightobj.get("Return_date"));
		}
		
		Home_page.search();
		
		
		Flight_Bookingpage Booking_page = new Flight_Bookingpage(driver ,test);
		//Booking_page.booking_page_validation();
		Booking_page.cancelalert();
		Booking_page.nonstop();
		Booking_page.viewpriceandbook();
		
		
		Flight_submitpage Submit_page = new Flight_submitpage(driver,test);
		
		//Submit_page.promocode();
		//Submit_page.securetrip();
		//Submit_page.add_free();
		Submit_page.price();
		Submit_page.mobilenumber((String) Flightobj.get("Mobile no."));
		Thread.sleep(2000);
		Submit_page.email((String) Flightobj.get("Email"));
		
		
		
		
		}
		
		
	
		
		
		
		
	}
	
	
	

}

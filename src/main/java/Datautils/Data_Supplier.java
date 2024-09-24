package Datautils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class Data_Supplier {
	
	@DataProvider(name = "Flight_data")

    public Object[][] datasupplier() throws IOException{
        String testInputSheetPath = "F:\\abhay\\com.Booking_flight\\Data_file\\Flight_data.xlsx";
        // String sheetName = FileReaderManager.getInstance().getConfiReader().getSheetName();
        String sheetName = "Flight_sheet";
        ExcelReader xl = new ExcelReader(testInputSheetPath);
        int flagYesCount = 0;
        int i=0;
        flagYesCount = xl.getCountofValuesInSheet(sheetName, "Flag", "Yes");
        Object [][] obj = new Object[flagYesCount][1];
        for(int row = 2;row<=xl.getRowCount(sheetName);row++){
            Map<Object,Object> dataObj = new HashMap<Object,Object>();
            if(xl.getCellData(sheetName, "Flag", row).equalsIgnoreCase("Yes")){
                for(int col = 1;col<=xl.getColumnCount(sheetName);col++){
                    dataObj.put(xl.getCellData(sheetName, col, 1), xl.getCellData(sheetName, col, row));
                }
                obj[i][0] = dataObj;
                i++;
            }
        }
        System.out.println("helllo");
        return obj;
    }
}



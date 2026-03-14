package practice;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import genericUtility.ExcelUtility;

public class CallingExcelUtilityMethod {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility exUtil = new ExcelUtility();
		String value1 = exUtil.getSingleCellDataFromExcel("Actors", 6, 0);
		System.out.println(value1);
		
		String value2 = exUtil.getSingleCellDataFromExcel("Cars", 9, 2);
		System.out.println(value2);
		
		//calling method for fetching multiple data from excel sheet
		//List<String> a1 = exUtil.getMultipleDataFromExcel("City", 1, 0);
		//System.out.println(a1);
		
		//calling methods for writeDataToExcel
		//exUtil.WriteDataToExcel("Family", 3, 3, "Manoj");
		//System.out.println();
	}

}

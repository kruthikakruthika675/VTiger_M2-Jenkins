package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.PropertiesUtility;

public class FetchingDataFromPropertiesFileUsingPropertiesUtility {
	public static void main(String[] args) throws IOException {
		PropertiesUtility pUtil = new PropertiesUtility();
		String URL = pUtil.getDataFromProperties("url");
		String UN = pUtil.getDataFromProperties("username");
		System.out.println(URL);
		System.out.println(UN);
		
		WebDriver driver = new EdgeDriver();
		driver.get(URL);
		pUtil.writeDataToPropertiesFile("user", "ravi", "user updated");
	
	}

}

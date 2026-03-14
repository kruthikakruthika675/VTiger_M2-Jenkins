package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.PropertiesUtility;

public class CallingPropertyFileMethod {
	public static void main(String[] args) throws IOException {
		PropertiesUtility pUtil = new PropertiesUtility();
		String URL = pUtil.getDataFromProperties("url");
		String username = pUtil.getDataFromProperties("username");
		
		System.out.println(URL);
		System.out.println(username);
		
		WebDriver driver = new EdgeDriver();
		driver.get(URL);
		pUtil.writeDataToPropertiesFile("user", "Manjunath", "user updated");
	}

}

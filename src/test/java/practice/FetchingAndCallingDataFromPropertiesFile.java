package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.PropertiesUtility;

public class FetchingAndCallingDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("username");
		System.out.println(URL);
		System.out.println(UN);
		WebDriver driver = new EdgeDriver();
		driver.get(URL);
		
		/*PropertiesUtility pUtil = new PropertiesUtility();
		String URL = pUtil.getDataFromProperties("url");
		String username = pUtil.getDataFromProperties("username");
		
		System.out.println(URL);
		System.out.println(username);
		
		WebDriver driver = new EdgeDriver();
		driver.get(URL);
		pUtil.writeDataToPropertiesFile("user", "Manjunath", "user updated");*/
		
	}

}

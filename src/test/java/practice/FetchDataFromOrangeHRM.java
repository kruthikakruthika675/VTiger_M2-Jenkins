package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class FetchDataFromOrangeHRM {
	public static void main(String[] args) throws IOException {
		
        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Data.properties1");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("username");
		String PWD = prop.getProperty("password");
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);
		
		WebDriver driver = new EdgeDriver();
		driver.get(URL);
		
		
		
	}

}

package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is an utility class to perform data driven from properties file
 * @author QSP
 * @version 26-02-02
 */
public class PropertiesUtility {
	
	/**
	 * This is an utility method to fetch data from Properties file
	 * @param key
	 * @return String
	 * @throws IOException
	 */
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathUtility.PropertiesPath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
	}
	
	/**
	 * This is an utility method to write data to Properties file
	 * @param key
	 * @param value
	 * @param message
	 * @throws IOException
	 */
	public void writeDataToPropertiesFile(String key, String value, String message) throws IOException {
		FileInputStream fis = new FileInputStream(IPathUtility.PropertiesPath);
		Properties prop = new Properties();
		prop.load(fis);
		prop.setProperty(key,  value);
		FileOutputStream fos = new FileOutputStream(IPathUtility.PropertiesPath);
		prop.store(fos, message);
	}

}

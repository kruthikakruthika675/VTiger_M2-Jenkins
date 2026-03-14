package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SeleniumUtility {
	/**
	 * this is generic method to access a web application
	 * @param driver
	 * @param url
	 */
	
	public void accessApplication(WebDriver driver, String url) {
		driver.get(url);
	}
	
	/*
	 * this is generic method to access a maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this is generic method to provide implicit wait
	 * @param driver
	 * @param maxTime
	 */
	public void implicitWait(WebDriver driver, int maxTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}
	
	/////////***handling mouse actions***/////////
	/**
	 * this is generic method to perform mouse hovering actions on an element
	 * @param driver
	 * @param element
	 */
	public void mouseHoveringActions(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * this is the generic method to perform double click actions on an element
	 * @param driver
	 * @param element
	 */
	
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * this is generic method to perform right click actions on an element
	 * @param driver
	 * @param element
	 */
	
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	//////*****handling dropdown*****//////
	/**
	 * this is generic method to select an option in a dropdown by using index
	 * @param dropdownEle
	 * @param index
	 */
	
	public void selectOptionByIndex(WebElement dropdownEle, int index) {
		Select sel = new Select(dropdownEle);
		sel.selectByIndex(index);
	}
	
	/**
	 * this is generic method to select an option in a dropdown by using value Attribute
	 * @param dropdownEle
	 * @param value
	 */
	public void selectOptionByValue(WebElement dropdownEle, String value) {
		Select sel = new Select(dropdownEle);
		sel.selectByValue(value);
	}
	
	/**
	 * this is generic method to select an option in a dropdown by using visible Text
	 * @param dropdownEle
	 * @param visibleText
	 */
	
	public void selectOptionByVisibleText(WebElement dropdownEle, String visibleText) {
		Select sel = new Select(dropdownEle);
		sel.selectByValue(visibleText);
	}
	
	//////*****handling alert popups*****//////
	/**
	 * this is generic method to accept an alert popups
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this is generic method to dismiss an alert popups
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	//////*****handling web page Screenshot*****//////
	/**
	 * this is generic method to capture the screenshot of web page
	 * @param driver
	 * @param screenshotName
	 * @return String
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath(); //used in listenners
	}

}

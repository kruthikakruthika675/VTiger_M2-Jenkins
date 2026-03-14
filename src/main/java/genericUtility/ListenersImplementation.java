package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	//to get all in method(globally)
	JavaUtility jUtil = new JavaUtility();//to provide screenshot name unique using date and time
	String dateTimeStamp = jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
	ExtentReports reports; //to create a empty report
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - On Test Start Executed");
		
		//Creating a field in Extent Reports
		test = reports.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - On Test Success Executed");
		
		//Logging the Status as PASS
		test.log(Status.PASS, methodName+ "- Successfully Executed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - On Test Failure Executed");
		
		//Logging the Status as FAIL
		test.log(Status.FAIL, methodName+ " - Failed");
		test.log(Status.INFO, result.getTestName());
	
	
		// Capturing Screenshot (capturing screenshot when it fails)
		//JavaUtility jUtil = new JavaUtility();// to provide screenshot name unique using date and time
		//String dateTimeStamp = jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
		String screenshotName = methodName + " - " + dateTimeStamp;
		SeleniumUtility sUtil = new SeleniumUtility();
		try {
			String path = sUtil.captureScreenshot(BaseClass.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path); //to attach the screenshot to the report
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - On Test Skipped Executed");
		
		//Logging the Status as SKIP
		test.log(Status.SKIP, methodName+ " - Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(" On Start Excecuted");
		
		//Configuration of Extent Reports
		ExtentSparkReporter reporter = new ExtentSparkReporter(".\\Extent Report\\report-"+dateTimeStamp+".html");
		reporter.config().setDocumentTitle("Extent Report"); //title name
		reporter.config().setReportName("VTiger Report"); //name of the report
		reporter.config().setTheme(Theme.DARK);
		
		//Generate empty report
		reports = new ExtentReports();
		reports.attachReporter(reporter); //to add the configuration to empty report
		reports.setSystemInfo("Base URL", "http://localhost:8888/");
		reports.setSystemInfo("Base Platform", "Windows");
		reports.setSystemInfo("Base Browser", "Edge");
		reports.setSystemInfo("Test Engineer", "Supritha");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" On Finish Executed");
		
		//Flushing the report
		reports.flush();
	}
	
	
	
	

}

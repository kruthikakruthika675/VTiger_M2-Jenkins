package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * This is an utility class deals with javaUtility
 * @author Krithika
 * @version 09-02-26
 */

public class JavaUtility {
	/**
	 * This is generic method to fetch calendar details
	 * @param pattern
	 * @return
	 */
	public String getCalendarDetails(String pattern) {
		Calendar cal = Calendar.getInstance();
		Date t = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String value = sdf.format(t);
		return value;
	}
	
	/**
	 * This is generic method to generate random numbers
	 * @param bound
	 * @return
	 */
	
	//random class is to generate unique data every time and we can concate the random number with data we get unique data 
	public int generateRandomNumber(int bound) {
		Random r = new Random();
		int num = r.nextInt(bound);
		return num;
	}

}

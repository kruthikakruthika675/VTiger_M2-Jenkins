package testngPractice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	@Test
	public void strictLevelComparisonSoftAssertion() {
		String expectedFood = "Benne Dosa";
		String actualFood ="Benn Dosa";
		System.out.println("Strict Level Soft Assertion stars");
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualFood, expectedFood);
		System.out.println("Strict Level Soft Assertion ends");
		s.assertFalse(actualFood.contains(expectedFood));
		s.assertAll();
	}
	
	@Test
	public void containsLevelComparisonSoftAssertion() {
		String expectedMovie = "Avatar";
		String actualMovie = "Avatar 3";
		System.out.println("Contains Level Soft Assertion starts");
		SoftAssert s = new SoftAssert();
		s.assertTrue(actualMovie.contains(expectedMovie));
		System.out.println("Contains Level Soft Assertion ends");
		s.assertAll();
	}

}

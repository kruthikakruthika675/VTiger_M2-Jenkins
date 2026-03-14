package testngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	
	@Test
	public void strictlevelComparisonHardAssertion() {
		String expectedCity = "Mysore";
		String actualCity = "Mysuru";
		System.out.println("Strict Level Hard Assertion starts");
		Assert.assertEquals(actualCity, expectedCity);
		System.out.println("Strict Level Hard Assertion ends");
	}
	
	@Test
	public void containsLevelComparisonHardAssertion() {
		String expectedName = "kru";
		String actualName = "Kruthi";
		System.out.println("Contains Level Hard Assertion starts");
		//Assert.assertTrue(actualName.contains(expectedName));
		Assert.assertEquals(actualName.contains(expectedName), true);
		System.out.println("Contains Level Hard Assertion ends");
	}

}

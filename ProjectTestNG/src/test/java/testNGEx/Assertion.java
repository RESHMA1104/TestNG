package testNGEx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
  @Test
  public void testAssertion() {
	  String s1 = new String("TestNG");
	  String s2 = new String("TestNG");
	  String s3 = null;
	  String s4 = "TestNG";
	  String s5 = "TestNG";
	  String s6 = new String("Not_TestNG");
	  int val1 = 5;
	  int val2 = 6;
	  //checks that two objects are equal
	  Assert.assertEquals(s1, s2);
	  
	  //checks that two objects are not equal
	  Assert.assertNotEquals(s1, s6);
	  
	  // checks that a condition is true
	  Assert.assertTrue(val1<val2);
	  System.out.println("True Assertion is successful");
	  
	  //
	  Assert.assertFalse(val1>val2);
	  System.out.println("False Assertion is successful");
	  
	  Assert.assertNotNull(s1);
	  System.out.println("Not Null Assertion is successful");
	  
	  Assert.assertNull(s3);
	  
	  Assert.assertSame(s4, s5);
	  System.out.println("Same assertion is successfull");
	  
	  Assert.assertNotSame(s1, s5);
	  System.out.println("Same assertion is not Successfull");
  }
}

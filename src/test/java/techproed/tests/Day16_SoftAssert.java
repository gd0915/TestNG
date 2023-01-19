package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day16_SoftAssert {
    /*
    Difference between Assertion(Hard Assertion) and Verification:
    ◦ In case of “Assert”,if the assertion fails, test method stops to execute the rest and marked as failed.
    ◦ In case of “Verification”,test method continue to execute even after the assertion statement fails.
    ==>>Soft assert is also known as verification
    ==>>Assertion means hard assertion. Verification means soft assertion. Verification is similar to if else statement.
     */

    @Test
    public void softAssertTest(){
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Line 11 Code");
        softAssert.assertEquals(3, 5);//FAILS
        System.out.println("Line 13 Code");
        softAssert.assertEquals("apple", "orange");//FAILS
        System.out.println("Line 15 Code");
        softAssert.assertTrue(false);//FAILS
        System.out.println("Line 17 Code");

        softAssert.assertAll();//Marking the test case as FAILED or PASSED

    }


}
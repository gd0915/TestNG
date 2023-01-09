package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day16_DependsOnMethods {

    @Test
    public void homePage(){
        System.out.println("I am on the home page");
    }

    @Test
    public void searchPage(){
        System.out.println("I am on the search page");//If it passes, then checkOutPage runs, so they are connected
        Assert.assertTrue(false);            //If this fails, then checkOutPage will be ignored
    }
    /*
    dependsOnMethods = "searchPage"  -> connecting checkOutPage to searchPage
    searchPage will execute right before checkOutPage
    If searchPage PASS -> execute checkoutPage
    If searchPage FAIL -> SKIP checkoutPage
 */

    @Test(dependsOnMethods = "searchPage")
    public void checkOutPage(){
        System.out.println("I am on the checkout page");
    }
}

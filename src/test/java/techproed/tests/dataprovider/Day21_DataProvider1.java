package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day21_DataProvider1 {
    /*
    What is data provider?
    Data provider is used to get list of data.
    We can get data from external sources/files, such as excel of json files.
    DataProvider is an annotation of TestNG
    I use DataProvider to get data such as credentials from excel sheet
    ==========================================================================
    Data provider is used outside the test method. It is like a utility class.
    Data provider will get the data and get it into the test method automatically.
    ==========================================================================
    How do you get data in your TestNG framework?
    In Data provider method, I use @DataProvider annotation, in Test method I give the method name in the parameter
    ==========================================================================
    Data Provider has 2 parameters:
    ****1. name : Used to give custom name for Data Provider
    ****2. parallel : Used to do parallel testing. Default is parallel = false. We can make it parallel = true.
     */

    // DATA PROVIDER METHOD
    @DataProvider(name = "my_smoke_data", parallel = true)  // This is not mandatory. We can give to DataProvider a custom name. In this case, we have to use this custom name in the test method.
    public Object[][] customerData(){
    // TEST DATA
        Object [][] customerCredentials = {
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
        return customerCredentials;
    }

//  TEST METHOD 1
    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest1(String username, String password){
        System.out.println("USERNAME : "+username+" | PASSWORD : "+password);
    }

    //  TEST METHOD 2
    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest2(String user, String pass){
        System.out.println(user+" | "+pass);
    }

}

package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day21_DataProvider1 {
    /*
    What is data provider?
    ****Data provider is used to get list of data.
    ****We can get data from external sources/files, such as excel of json files.
    ****DataProvider is an annotation of TestNG
    ****I use DataProvider to get data such as credentials from excel sheet
    ==========================================================================
    @Data provider is used outside the test method in the same class. It is like a utility class to hold test data.
    If we do not have too much test data we can prefer to use DataProvider method to hold the test data. If there is too much test data, we use 'excel'.
    Data provider will be used in each @Test method and call the DataProvider method, and get the data into the test method automatically.
    ==========================================================================
    How do you get data in your TestNG framework?
    ****In Data provider method, I use @DataProvider annotation, in Test method I give the method name in the parameter
    ==========================================================================
    Data Provider has 2 parameters:
    ****1. name : Used to give custom name for Data Provider
    ****2. parallel : Used to do parallel testing. Default is parallel = false. We can make it parallel = true.
     */

    // DATA PROVIDER METHOD
    // This method will hold the customer data as 2D Object.
    @DataProvider(name = "my_smoke_data", parallel = true)  // This is not mandatory. We can give to DataProvider a custom name.
                                                            // In this case, we have to use this custom name in the test method.
    public Object[][] customerData(){
    // TEST DATA
        Object [][] customerCredentials = {
                {"sam.walker@bluerentalcars.com","c!fas_art"}, //Kind of JSon file
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

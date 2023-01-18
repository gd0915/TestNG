package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.page.HomePage;
import techproed.page.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class Day21_DataProvider3 {
    /*
 In this method, we will get the data from EXCEL using DATA PROVIDER
 The only difference between class 2 and class 3 is the place where we get the data
 In class 2, we received the data from the class itself. In this class, we get the data from excel.
  */
    HomePage homePage;
    LoginPage loginPage;
    @DataProvider
    public Object[][] customerData(){
//    TEST DATA. GET DATA FROM EXCEL
//        PATH OF EXCEL SHEET
        String path="src/test/java/resources/mysmoketestdata.xlsx";
//        SHEET NAME
        String sheetName = "customer_info";
//        CALL EXCEL UTIL CLASS
        ExcelUtils excelUtils=new ExcelUtils(path,sheetName);
//        USE ONE OF THE EXCEL UTIL METHOD TO RECEIVE THE DATA FROM THE EXCEL

        Object [][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow();
//        Object [][] customerCredentials = {
//                {"sam.walker@bluerentalcars.com","c!fas_art"},
//                {"kate.brown@bluerentalcars.com","tad1$Fas"},
//                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
//                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
//        };
        return customerCredentials;
    }
    //    1. Create a login method
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new HomePage();
        loginPage =new LoginPage();
        ReusableMethods.waitFor(1);
        try {
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        try{
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        ReusableMethods.waitFor(1);
    }
    @Test(dataProvider = "customerData")
    public void customerLoginTest(String username, String password){
//            Takes us to the login page
        login();
        loginPage.userName.sendKeys(username);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(password);
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
        ReusableMethods.verifyElementDisplayed(homePage.userID);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
/*
RECAP
TestNG xml files:
What is it?
An xml file can be used for test case groups, and do configuration. For example, pom.xml is used to add dependencies.
TestNG xml files are used to create custom test groups such as class level test groups, package level test groups,…
TestNG xml files are an alternative way of creating and running test cases.
Why did you use?
I used some xml files to run tests in parallel, set test priorities, and run specific test groups
How did you use in your current framework?
I used some xml files to run tests in parallel, set test priorities, and run specific test groups my current framework.
Data Provider:
What is it?
Data provider is a testNG functionality.
It is used to provide test data to the test cases in automation.
It returns the data as 2D array
Data provider has 2 parameters : name(to override the method name) and parallel(for doing parallel testing)
How did you use it?
I used it when I was using testNG framework. In fact, I used data provider to get some of the test data from the excel sheet.
We store the login credentials in excel and used data provider to get the data from there. The benefit was I can get multiple data without any loop.
 */

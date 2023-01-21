package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day20_ExcelLogin {

    HomePage homePage;
    LoginPage loginPage;
    ExcelUtils excelUtils;
    //    will store excel data
    List<Map<String,String>> allTestData;

    //    1. Create a login method
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new HomePage();
        loginPage =new LoginPage();
        ReusableMethods.waitFor(3);
        try {
            homePage.homePageLoginLink.click();
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
        ReusableMethods.waitFor(3);

        /*

        click on login LINK     --------->>>>>> homePage.homePageLoginLink.click();  --->>> Try when link is there
        send username
        send password           --------->>>>>> DONE
        click on login button   --------->>>>>>
        I AM ON HOME PAGE
        ********PATTERN 1***********
        click on user id
        click on log out       --------->>>>>> 2nd TRY CATCH -->> logIn
        click on ok
        I AM ON HOME PAGE AGAIN
        ********PATTERN 2***********
        click on Login link
        send username
        send password          ---------->>>>>>@Test method is used to send credentials and verification
        click on login button
        I AM ON HOME PAGE AGAIN
        ********PATTERN 3***********
        click on user id
        click on log out
        click on ok            --------->>>>>>2nd TRY CATCH -> logIn
        I AM ON HOME PAGE AGAIN
        *******PATTERN 4************
        click on Login link
        send username
        send password          --------->>>>>>@Test method is used to send credentials and verification
        click on login button
        I AM ON HOME PAGE AGAIN
         */

    }
    @Test
    public void customerLoginTest(){
        String path="./src/test/java/resources/mysmoketestdata.xlsx"; // path of the excel sheet(content root)
        String sheetName = "customer_info";
        excelUtils=new ExcelUtils(path,sheetName);
//        getDataList() method returns all excel data
//        we stored that data in allTestData variable
        allTestData=excelUtils.getDataList();
//        System.out.println(allTestData);
//        System.out.println(excelUtils.getColumnsNames());
//        System.out.println(excelUtils.getCellData(2,1));
//        USING LOOP GET THE VALUES FROM THE MAP AND SEND INTO THE UI
        for (Map<String,String> eachData :allTestData){
//            Takes us to the login page
            login();
            loginPage.userName.sendKeys(eachData.get("username")); // eachData is a Map
//                                                                             // with get() method send key and get value
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
            ReusableMethods.verifyElementDisplayed(homePage.userID);
        }

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}

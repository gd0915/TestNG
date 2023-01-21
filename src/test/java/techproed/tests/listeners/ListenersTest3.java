package techproed.tests.listeners;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class ListenersTest3 {
    // File //Settings // Plugins // MarketPlace ==>> testNG // Create TestNG XML Install
    // right click on Test Class ==>> create TestNG XML
    // Code // Reformat file ==>> to get the content of the xml file

    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void US100201_Admin_Login(){
        //going to blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click on home page login link
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();

        //sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        loginPage.userName.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("1234567890");//sending incorrect credential // THIS WILL FAIL
        ReusableMethods.waitFor(3);

        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);

        //verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);
        //ALTERNATIVELY WE CAN ASSERT IF HOME PAGE LOGIN LINK IS NOT DISPLAYED. NOT RECOMMENDED
        //ReusableMethods.verifyElementNotDisplayed(homePage.homePageLoginLink);

        Driver.closeDriver();

    }
}

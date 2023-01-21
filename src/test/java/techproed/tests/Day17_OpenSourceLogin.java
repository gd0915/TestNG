package techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day17_OpenSourceLogin {
    /*
    POM:

    POM focuses on re-usability. (reusable WebElements)
    i- pages
    ii- tests
    iii- utilities
    We are going to especially focussing on Pages package. In the Pages Package, we create reusable page objects such as button, checkbox...
    We will keep calling them again and again.

    1. Locate the page object in the pages package
    -username
    -password
    -button

    Note: Use constructor to instantiate page objects

    2. In test class, create page object to access the objects in the page class
     */

    /*
    Create a test case to login the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    using page object model
     */
    @Test
    public void loginTest(){
        OpenSourcePage openSourcePage = new OpenSourcePage();
        Driver.getDriver().get(ConfigReader.getProperty("open_source_URL"));
        openSourcePage.userName.sendKeys("Admin");
        openSourcePage.password.sendKeys("admin123");
        openSourcePage.submitButton.click();
    }

    @AfterMethod
    public void closeBrowser(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}

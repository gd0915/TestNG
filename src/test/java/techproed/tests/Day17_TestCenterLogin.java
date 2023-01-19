package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.TestCenterPage;
import techproed.pages.TestHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day17_TestCenterLogin {

    @Test
    public void loginTest(){
        TestCenterPage testCenterPage = new TestCenterPage();
        Driver.getDriver().get(ConfigReader.getProperty("testcenter_URL"));
        TestHomePage testHomePage = new TestHomePage();
        testCenterPage.username.sendKeys("techproed");
        testCenterPage.password.sendKeys("SuperSecretPassword");
        testCenterPage.submitButton.click();
        //verifying login is successful
        //Assert.assertTrue(testHomePage.loginMessage.isDisplayed());
        // DONE WITH REUSABLE METHOD. RECOMMENDED.
        ReusableMethods.verifyElementDisplayed(testHomePage.loginMessage);
    }

}

package techproed.tests;

import org.testng.annotations.Test;
import techproed.page.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day17_TestCenterLogin {

    @Test
    public void loginTest(){
        TestCenterPage testCenterPage = new TestCenterPage();
        Driver.getDriver().get(ConfigReader.getProperty("testcenter_URL"));
        testCenterPage.username.sendKeys("JohnDoe");
        testCenterPage.password.sendKeys("123456");
        testCenterPage.submitButton.click();

    }

}

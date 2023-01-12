package techproed.tests.smoketest.logintests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.page.HomePage;
import techproed.page.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_NegativeLoginTest {
    /*
    Name:
    Login screen error messages
    Description:
    User should see error message when user tries to login with incorrect credentials
    Acceptance Criteria:
    As admin or customer, I should be able to see error message,
    when I provide a correct email address BUT incorrect password in a pop up window
    Error Message: Bad credentials
    https://www.bluerentalcars.com/
    Admin email: jack@gmail.com
    Admin wrong password: 54321
     */
    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void negativeLoginTestWithWrongPassword(){
        //going to blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click on home page login link
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();

        //sending credentials(valid email, invalid password)  and clicking on login button
        ReusableMethods.waitFor(3);
        loginPage.userName.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("56789");
        ReusableMethods.waitFor(3);

        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);

        //verify user should be able to see error message
        //1st way
        ReusableMethods.verifyElementDisplayed(loginPage.errorMessage);
        //2nd way
        ReusableMethods.verifyElementDisplayed(loginPage.secondLogin);
    }

    /*
    Name:
    Login screen error messages
    Description:
    User should see error message when an invalid email is entered
    Acceptance Criteria:
    As admin or customer, I should be able to see error message, when I do not provide a complete valid email address in email address box
    Error Message: email must be a valid email
    When I enter a valid email domain, then I should not see the error message
    https://email-verify.my-addr.com/list-of-most-popular-email-domains.php
     */
    @Test
    public void negativeLoginTestWithInvalidEmail(){
        //going to blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click on home page login link
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();

        //sending credentials(invalid or incomplete email)
        ReusableMethods.waitFor(3);
        loginPage.userName.sendKeys("jack");

        //verify user should be able to see error message
        ReusableMethods.waitFor(3);
        ReusableMethods.verifyElementDisplayed(loginPage.invalidEmailMessage);

        //verify user should not see the error message when user enters a valid email domain
        loginPage.userName.sendKeys("@gmail.com");
        ReusableMethods.verifyElementNotDisplayed(loginPage.invalidEmailMessage);
        //Assert.assertFalse(loginPage.invalidEmailMessage.getText().equals("email must be a valid email"));

    }
}

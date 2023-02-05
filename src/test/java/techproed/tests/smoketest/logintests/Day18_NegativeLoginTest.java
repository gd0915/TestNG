package techproed.tests.smoketest.logintests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

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
    Faker faker;
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
        Driver.closeDriver();
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
    public void US100208_Negative_Login_WithIncorrectEmail(){  //User story name
        //going to blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click on home page login link
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(2);
        homePage.homePageLoginLink.click();

        //sending credentials(invalid or incomplete email)
        ReusableMethods.waitFor(2);
        loginPage.userName.sendKeys("jack");

        //verify user should be able to see error message
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(loginPage.invalidEmailMessage);

        //verify user should not see the error message when user enters a valid email domain
//        ReusableMethods.waitFor(2);
//        loginPage.userName.clear();
//        ReusableMethods.waitFor(2);
//        Driver.getDriver().navigate().back();
//        Driver.getDriver().navigate().forward();
        Driver.getDriver().navigate().refresh();
        loginPage.userName.sendKeys( "jack@gmail.com");
        ReusableMethods.verifyElementNotDisplayed(loginPage.invalidEmailMessage);

        //Assert.assertFalse(loginPage.invalidEmailMessage.getText().equals("email must be a valid email"));
        Driver.closeDriver();

    }
    /*
    Name:
    US100208_Negative_Login
    Description:
    User should not be able login with incorrect credentials
    Acceptance Criteria:
    As customer, I should not be able to log in the application
    Customer email: fake@bluerentalcars.com
    Customer password: fakepass
    Error: User with fake@bluerentalcars.com not found
     */
    @Test(groups = "minor-regression-group", retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void US100208_Negative_Login() throws IOException {

//        As customer, I should not be able to log in the application
//        going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

//        click on home page login link
        homePage = new HomePage();
        loginPage= new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();

//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);

//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        loginPage.userName.sendKeys("fake@bluerentalcars.com");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("fakepass");
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);

//        Error: User with fake@bluerentalcars.com not found
        ReusableMethods.verifyElementDisplayed(loginPage.errorMessage_incorrectEmailPass);//Verifying is not complete
        // this reusable method does not check if the actual message equals to expected one

        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
        Driver.closeDriver();
    }

    @Test
    public void invalidCredsTest() throws IOException {
        //        As customer, I should not be able to log in the application
//        going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

//        click on home page login link
        homePage = new HomePage();
        loginPage= new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();

//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);

//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        loginPage.userName.sendKeys(fakeEmail);
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys(faker.internet().password(4,6));//fake pass 4-6 digit
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);

//        Error: User with fake@bluerentalcars.com not found
        ReusableMethods.verifyElementDisplayed(loginPage.errorMessage_incorrectEmailPass);//Verifying is not complete
        // this reusable method does not check if the actual message equals to expected one

        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email "+fakeEmail+" not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
        Driver.closeDriver();
    }
}

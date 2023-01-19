package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.SaucedemoHomePage;
import techproed.pages.Saucedemo_ProductsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

public class SaucedemoPrice {
    /*
    Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  Then
    Assert that total price of all products is 129.94 dollars
  And
    Flash each web element you used
     */

    @Test(groups="practice-smoke-test-group")
    public void totalPrice(){
//        Go to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("saucedemo_url"));

//        Enter the username  as "standard_user"
        SaucedemoHomePage saucedemoHomePage = new SaucedemoHomePage();
        JSUtils.flash(saucedemoHomePage.usernameInput);// flash() method use for flashing
        saucedemoHomePage.usernameInput.sendKeys(ConfigReader.getProperty("saucedemo_username"));

//        Enter the password as "secret_sauce"
        JSUtils.flash(saucedemoHomePage.passwordInput);
        saucedemoHomePage.passwordInput.sendKeys(ConfigReader.getProperty("saucedemo_password"));

//        Click on login button
        JSUtils.flash(saucedemoHomePage.loginButton);
        saucedemoHomePage.loginButton.click();

//        Assert that total price of all products is 129.94 dollars
        Saucedemo_ProductsPage saucedemo_productsPage = new Saucedemo_ProductsPage();
        double sum = 0.0;
        for(WebElement eachPrice : saucedemo_productsPage.prices){
            JSUtils.flash(eachPrice);
            //sum += Double.parseDouble(eachPrice.getText().substring(1));
            sum += Double.parseDouble(eachPrice.getText().replaceAll("\\$", ""));
        }
        System.out.println("Total price : " + sum);

        Assert.assertEquals(129.94, sum);

//        Flash each web element you used

        Driver.closeDriver();



    }
}

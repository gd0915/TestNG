package techproed.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCenterPage {

    //Create constructor to instantiate the page objects
    public TestCenterPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Locate the page objects
    @FindBy(id = "exampleInputEmail1")
    public WebElement username;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

}
/*
NOTE: i.  PageFactory class is used to instantiate the page object class and its elements.
      ii. PageFactory supports initElements static method which actually instantiate the elements
 */

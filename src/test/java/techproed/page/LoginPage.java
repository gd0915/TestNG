package techproed.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Bad credentials']")
    public WebElement errorMessage;

    @FindBy(xpath = "(//*[text()=' Login'])[2]")
    public WebElement secondLogin;

    @FindBy(xpath = "//*[text()='email must be a valid email']")
    public WebElement invalidEmailMessage;


}

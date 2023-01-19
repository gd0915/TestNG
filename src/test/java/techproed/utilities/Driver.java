package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
//  Driver.getDriver(); -> driver
    private static WebDriver driver;
//  getDriver() is used to instantiate the driver object
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
            }


          // driver = WebDriverManager.chromedriver().create(); // NOTE===>>>new method after Selenium 4.5.

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));    // Whenever we call the driver it is going to be triggered
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));   // coming from Selenium
        driver.manage().window().maximize();
        return driver;
    }
//  closeDriver() is used to close the driver
   public static void closeDriver(){

//      if driver is already being used(pointing an object)
//      then quit the driver
            if(driver!=null){
                driver.quit();
                driver=null;
            }
        }
}

/*
    We will have Driver class in our utilities package to create and initialize driver.
    This Driver class will return one single static driver that is being shared in all classes.
    Driver class will allow us to use same driver object across all classes in the framework
    When ever 'Singleton Driver class' instantiated, this Driver class will return the same driver instance again and again.
    This is called 'Singleton design pattern'
    The reason of Driver class is to create and initialize driver, not use that system.setproperties, webdrivermanager, etc.
    So it is similar to TestBase class

    Question: Where do you static keyword in your framework?
    Answer  : In my Driver class, our driver is static, so it can be shared across the framework(or so driver instance can be
    used globally in the framework)
 */

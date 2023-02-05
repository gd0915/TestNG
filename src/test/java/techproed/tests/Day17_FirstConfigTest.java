package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day17_FirstConfigTest {
    @Test
    public void firstConfigTest(){

       // Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed"));

       // Verify the title contains Techpro Education
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(ConfigReader.getProperty("app_title")));
    }

}
/*
JUnit: A testing framework. Has less annotation compare to TestNG
TestNG: An advanced testing framework. Advanced version of JUnit framework
Page Object Model: Popular Framework Design. We use page  object model for creating reusable page objects and methods.
Maven: Project built tool. With maven, we can easily add other dependencies(junit,testng,selenium, faker, poi,…) to our project. Instead of importing the jar files, we just add the dependency in the pom.xml file. Then maven automatically imports jar pies for us. Developers may also use maven for their their project built.
Selenium: Selenium is used to test web based application. We can also do mobile testing with 3rd party tool such as appium.
 */

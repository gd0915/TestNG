package techproed.tests.smoketest.reservationtests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.page.HomePage;
import techproed.page.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Day19_Reservation {
    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test
    public void reservationTest(){
    //Name:
    //User should be able to reserve a car
    //Description:
    //User should be able to reserve a car as customer service profile

    //Acceptance Criteria:

    //Given user is on the home page
     Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

    // Login the app
     loginPage = new LoginPage();
     ReusableMethods.waitFor(3);
     homePage.homePageLoginLink.click();

    //sending credentials and clicking on login button
     ReusableMethods.waitFor(3);
     loginPage.userName.sendKeys("jack@gmail.com");
     ReusableMethods.waitFor(3);
     loginPage.password.sendKeys("12345");
     ReusableMethods.waitFor(3);

     loginPage.loginButton.click();
     ReusableMethods.waitFor(3);

    //verify login is successful
     ReusableMethods.verifyElementDisplayed(homePage.userID);

    // NOW THAT YOU LOGGED IN THE APPLICATION, WE CAN ENTER THE REQUIRED FIELDS
    //And select a car
     homePage = new HomePage();
     Select carSelect = new Select(homePage.selectACar);
     carSelect.selectByIndex(3);

    //And enter pick up field
     faker = new Faker();// not obligatory in this situation, I am using Faker instance
     homePage.pickUpLocation.sendKeys(Faker.instance(Locale.UK).address().cityName());

    //And enter drop off field
     homePage.dropOfLocation.sendKeys(Faker.instance(Locale.US).address().cityName());

     //Pick Up Date
     //Pick Up Time
     //Drop off Date
     //Drop off Time

    // SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
        Calendar calendar=Calendar.getInstance();
    //  calendar.add(Calendar.YEAR,30);
    //  homePage.pickUpDate.sendKeys(simpleDateFormat.format(calendar.getTime()));

        //enter pick up date
        homePage.pickUpDate.sendKeys("10/10/2025");
        //enter pick up hour
        homePage.pickUpTime.sendKeys(simpleDateFormat1.format(new Date()));

    //    calendar.add(Calendar.MONTH,1);
    //    homePage.dropOffDate.sendKeys(simpleDateFormat.format(calendar.getTime()));

        //enter drop off date
        homePage.dropOffDate.sendKeys("10/11/2025");
    //        calendar.add(Calendar.HOUR,1);
        //enter drop off hour
        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));


        // ==================================================================================
    //And click continue reservation
        homePage.continueReservationButton.click();

//      CAR IS NOT RESERVED There is a BLOCKER.......

    //And verify complete reservation screen pops up

    //And enter card number
    //And enter name on the card
    //And enter expire date and CVC
    //And checks the agreement
    //And click complete reservation
    //Then verify ‘Reservation created successfully’ pop up
    //And navigated to Reservations screen
    //And verify the last reservation is created
    //When you click on the last reservation
    //Then verify reservation detail page is displayed
    //And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
    //And click on back to reservations
    //And verify Reservations page is displayed
    //And click on Home link
    //Then verify the home page is displayed
    }
}
/*
ALTERNATIVE WAY
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ddMMyyyy");
        String today=simpleDateFormat.format(new Date());
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");//aa means AM/PM
        String time= simpleDateFormat1.format(new Date());
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,30);
    // homePage.pickUpDate.sendKeys(simpleDateFormat.format(calendar.getTime()));
        homePage.pickUpDate.sendKeys("10/10/2035");
        homePage.pickUpTime.sendKeys(time);
        calendar.add(Calendar.MONTH,1);
    // homePage.dropOffDate.sendKeys(simpleDateFormat.format(calendar.getTime()));
        homePage.dropOffDate.sendKeys("10/11/2035");
        calendar.add(Calendar.HOUR,1);
        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));
    // homePage.pickUpTime.sendKeys("07:00");

 */

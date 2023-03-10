package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

//USE @LISTENER ANNOTATION TO CONNECT TEST CLASS TO THE LISTENERS
//techproed.utilities.Listeners.class -> PATH OF LISTENERS UTILITY
@Listeners(techproed.utilities.Listeners.class)
public class ListenersTest1 {

    @Test
    public void test01(){
        System.out.println("Test case 1 PASS");
        Assert.assertTrue(true);//PASS
    }

    @Test
    public void test02(){
        System.out.println("Test case 2 FAIL");
        Assert.assertTrue(false);//FAILS
    }

    @Test
    public void test03(){
        System.out.println("Test case 3 SKIPPED");
        throw new SkipException("SKIP THIS TEST CASE");
    }

    @Test
    public void test04(){
        System.out.println("Test case 4 NO SUCH ELEMENT EXCEPTION");
        Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().findElement(By.xpath("asegsdgga"));//NO SUCH ELEMENT EXCEPTION
    }
}

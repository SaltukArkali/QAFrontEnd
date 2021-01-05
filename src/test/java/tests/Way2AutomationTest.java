package tests;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Way2AutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

public class Way2AutomationTest extends TestBase {

    Way2AutomationPage pageElements = new Way2AutomationPage(Driver.getDriver());
    Actions actions=new Actions(Driver.getDriver());

    @BeforeMethod
    public void testSignIn(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.waitFor(1);
        pageElements.signInLink.click();
        ReusableMethods.waitFor(2);
        pageElements.username.sendKeys(ConfigReader.getProperty("valid_username"));
        pageElements.password.sendKeys(ConfigReader.getProperty("valid_password"));
        ReusableMethods.waitFor(1);
        pageElements.submitButton.click();
    }

    @Test
    public void defaultFunctionality(){
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pageElements.draggableLink.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);
        String value1= pageElements.draggableBox.getAttribute("style");
        System.out.println(value1);
        Assert.assertEquals(value1,"position: relative;");
        actions.clickAndHold(pageElements.draggableBox).perform();
        ReusableMethods.waitFor(2);
        actions.moveByOffset(100,150).perform();
        String value2= pageElements.draggableBox.getAttribute("style");
        System.out.println(value2);
        Assert.assertNotEquals(value2,"position: relative;");
        Assert.assertTrue(value2.contains("width"));
        actions.release().perform();
    }

    @Test
    public void constrainMovement(){

    }
    @Test
    public void cursorStyle(){

    }
    @Test
    public void events(){

    }
    @Test
    public void draggableSortable(){

    }

}

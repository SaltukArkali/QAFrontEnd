package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Way2AutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Way2AutTestResizable {


    Way2AutomationPage pageElements = new Way2AutomationPage();
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
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pageElements.resizableLink.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);
        String valueBefore = pageElements.getResizableValue.getAttribute("style");
        System.out.println("Before = " + valueBefore);
        Assert.assertTrue(valueBefore.isEmpty());
        actions.clickAndHold(pageElements.cursorResizable.get(0)).build().perform();
        actions.moveByOffset(200,100).perform();
        ReusableMethods.waitFor(1);
        String valueAfter = pageElements.getResizableValue.getAttribute("style");
        System.out.println("After = " + valueAfter);
        Assert.assertEquals(valueAfter,"width: 350px; height: 250px;");

    }
    @Test
    public void animate(){
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pageElements.resizableLink.click();
        ReusableMethods.waitFor(2);



    }
    @Test
    public void constrainResizeArea(){

    }
    @Test
    public void helper(){

    }
    @Test
    public void maxMinSize(){

    }




}

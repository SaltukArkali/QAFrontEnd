package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Way2AutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Way2AutTestAccordion {

    Way2AutomationPage accordion = new Way2AutomationPage();
    Actions actions=new Actions(Driver.getDriver());

    @BeforeMethod
    public void testSignIn(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.waitFor(1);
        accordion.signInLink.click();
        ReusableMethods.waitFor(2);
        accordion.username.sendKeys(ConfigReader.getProperty("valid_username"));
        accordion.password.sendKeys(ConfigReader.getProperty("valid_password"));
        ReusableMethods.waitFor(1);
        accordion.submitButton.click();
    }

    @Test
    public void test01(){
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        accordion.accordionLink.click();
        accordion.customizeIconsLink.click();
        Driver.getDriver().switchTo().frame(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        for (WebElement w:accordion.sectionList) {
            ReusableMethods.waitFor(1);
            actions.click(w).perform();
            System.out.println(w.getText());
            Assert.assertTrue(w.isEnabled());
            for (WebElement y: accordion.paragrafList) {
               ReusableMethods.waitFor(1);
               System.out.println(y.getText());
               Assert.assertTrue(y.isDisplayed());
            }
        }

    }

    @Test
    public void test02(){
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        accordion.accordionLink.click();
        accordion.fillSpaceLink.click();
        Driver.getDriver().switchTo().frame(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        ReusableMethods.waitFor(1);
        actions.clickAndHold(accordion.accordionCursor).moveByOffset(400,0).release().build().perform();
        actions.release(accordion.accordionCursor).build().perform();
        actions.clickAndHold(accordion.accordionCursor).moveByOffset(0,200).release().build().perform();
        actions.release(accordion.accordionCursor).build().perform();

//        for (WebElement w:accordion.sectionList) {
//            ReusableMethods.waitFor(1);
//            actions.click(w).perform();
//            System.out.println(w.getText());
//            Assert.assertTrue(w.isEnabled());
//            for (WebElement y: accordion.paragrafList) {
//                ReusableMethods.waitFor(1);
//                System.out.println(y.getText());
//                Assert.assertTrue(y.isDisplayed());
//            }
//        }


    }


}

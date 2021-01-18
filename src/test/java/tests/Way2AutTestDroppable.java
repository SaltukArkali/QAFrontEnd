package tests;

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

public class Way2AutTestDroppable {

    Way2AutomationPage selectable = new Way2AutomationPage();
    Actions actions = new Actions(Driver.getDriver());


    @BeforeMethod
    public void testSignIn(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.waitFor(1);
        selectable.signInLink.click();
        ReusableMethods.waitFor(2);
        selectable.username.sendKeys(ConfigReader.getProperty("valid_username"));
        selectable.password.sendKeys(ConfigReader.getProperty("valid_password"));
        ReusableMethods.waitFor(1);
        selectable.submitButton.click();
    }

    @Test
    public void test01(){
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selectable.selectableLink.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);

        for (WebElement w: selectable.selectFirstList) {
            System.out.println(w.getText());
            w.click();
            System.out.println(w.getCssValue("background-color"));
            Assert.assertEquals(w.getCssValue("background-color"),"rgba(243, 152, 20, 1)");
        }

        Driver.getDriver().switchTo().defaultContent();
    //    System.out.println(selectable.selectFirstList.get(0).getText());

        ReusableMethods.waitFor(2);
        selectable.displayAsGridLink.click();
        ReusableMethods.waitFor(1);

        Driver.getDriver().switchTo().frame(1);
        for (WebElement w: selectable.selectSecondList) {
            System.out.println(w.getText());
            w.click();
            System.out.println(w.getCssValue("background-color"));
            Assert.assertEquals(w.getCssValue("background-color"),"rgba(243, 152, 20, 1)");
        }
        Driver.getDriver().switchTo().defaultContent();

        ReusableMethods.waitFor(2);
        selectable.serializeLink.click();
        ReusableMethods.waitFor(1);

        Driver.getDriver().switchTo().frame(2);
        int i = 0;
        for (WebElement w: selectable.selectThirdList) {
            System.out.println(w.getText());
            w.click();
            System.out.println(w.getCssValue("background-color"));
            Assert.assertEquals(w.getCssValue("background-color"),"rgba(243, 152, 20, 1)");
            i++;
            System.out.println(selectable.itemNo.getText());
            Assert.assertTrue(selectable.itemNo.getText().equals("#"+i));
            System.out.println(i);
        }

    }

}

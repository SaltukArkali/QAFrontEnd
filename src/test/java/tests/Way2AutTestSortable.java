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

import javax.swing.*;

public class Way2AutTestSortable {

    Way2AutomationPage sortable = new Way2AutomationPage();
    Actions actions =new Actions(Driver.getDriver());

    @BeforeMethod
    public void testSignIn(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.waitFor(1);
        sortable.signInLink.click();
        ReusableMethods.waitFor(2);
        sortable.username.sendKeys(ConfigReader.getProperty("valid_username"));
        sortable.password.sendKeys(ConfigReader.getProperty("valid_password"));
        ReusableMethods.waitFor(1);
        sortable.submitButton.click();
    }

    @Test
    public void sortable01() {
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        sortable.sortableLink.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);

//        int i =6;
//        for (WebElement w: sortable.sortableList1) {
//            actions.clickAndHold(w).moveToElement(sortable.sortableList1.get(i),0,10).release().build().perform();
//            i--;
//            if (i==0)break;
//            ReusableMethods.waitFor(1);
//        }
        for (WebElement w : sortable.sortableList1) {
            actions.clickAndHold(w).moveToElement(sortable.sortableList1.get(0)).release().perform();
        }

        for (int i=0; i<7; i++){
            System.out.println(sortable.sortableList1.get(i).getText());
            Assert.assertEquals(sortable.sortableList1.get(i).getText(),"Item "+(7-i));
        }

    }

}

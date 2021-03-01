package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SelEasyPage02;
import pages.SelEasyPage03;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelEasyTest03 {

    SelEasyPage03 selEasyPage03 = new SelEasyPage03();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void before() {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasy"));
        ReusableMethods.waitFor(1);
    }

    public void entrance() {
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage03.startPracticing.click();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage03.javascrıptAlertsLink.click();
        ReusableMethods.waitFor(1);
    }

    @Test
    public void TC0301() {
//        The user clicks on "Start Practicing"
//        The user clicks on "Javascript Alerts"
        if (selEasyPage03.closeSign.isDisplayed()) {
            selEasyPage03.closeSign.click();
        }
        entrance();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(selEasyPage03.mainText.getText().contains("Alert box, Confirm box, and Prompt box"));
    }

    @Test
            public void TC0302(){
//    public void TC0302() {
//        Kullanici, "Java Script Alert Box" panelinde bulunan 'Click me!' butonuna tiklar
//        ve pops up'daki "I am alert box!" mesajini alip dogrular. Sonra mesaji kapatir.
        entrance();
        ReusableMethods.waitFor(1);
        selEasyPage03.alertBoxButton.click();
        ReusableMethods.waitFor(2);
        String alert01Text = Driver.getDriver().switchTo().alert().getText();
        System.out.println(alert01Text);
        Assert.assertEquals(alert01Text,"I am an alert box!");
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().accept();
    }

    @Test
    public void TC0303() {
//        Kullanici, "Java Script Confirm Box" panelinde bulunan 'Click me!' butonuna tikladiktan sonra
//        pops up'taki 'Cancel' butonuna tiklar ve panelin en alt satirinda cikan 'You pressed Cancel!'
//        mesajini dogrular.
        entrance();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage03.confirmBoxButton.click();
        ReusableMethods.waitFor(1);
        String alert02Text = Driver.getDriver().switchTo().alert().getText();
        System.out.println(alert02Text);
        Assert.assertEquals(alert02Text,"Press a button!");
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().dismiss();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(selEasyPage03.confirmBoxText.isDisplayed());
        Assert.assertEquals(selEasyPage03.confirmBoxText.getText(),"You pressed Cancel!");
    }

    @Test
    public void TC0304() {
//        Kullanici, "Java Script Alert Box" panelinde bulunan 'Click for Prompt Box' butonuna tikladiktan
//        sonra pops up'taki 'Please enter your name'  box'ina ismini yazar ve 'OK' butonuna tiklar ve
//        panelin en alt satirinda cikan ornegin 'You have entered 'Ali' !' mesajini dogrular.
        entrance();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage03.alertBoxPromptButton.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().sendKeys("Saltuk");
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.waitFor(1);
        Assert.assertEquals(selEasyPage03.promptBoxText.getText(),"You have entered 'Saltuk' !");

    }
}


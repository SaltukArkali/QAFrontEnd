package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SelEasyPage01;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SelEasyTest01 {

    SelEasyPage01 selEasyPage01 = new SelEasyPage01();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void testMainPage() {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasy"));
 //       Driver.getDriver().switchTo().alert().dismiss();
        ReusableMethods.waitFor(1);
    }

    @Test
    public void TC0101() {
        selEasyPage01.closeSign.click();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage01.startPracticing.click();
 //     actions.click(selEasyPage01.startPracticing).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void TC0102() {
        selEasyPage01.startPracticing.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage01.simpleFormDemoLink.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void TC0103() {
//        Kullanici, Single Input Field basligi altindaki "Enter message" box'ina mesaj yazdidinda ve
//        "Show Message" butonuna tikladiginda "Your Message:" kisminda mesaj box'ina yazmis
//        oldugu mesaji gormeli ve dogrulamalidir
        selEasyPage01.startPracticing.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage01.simpleFormDemoLink.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage01.enterMessageBox.sendKeys("Hallo");
        ReusableMethods.waitFor(1);
        selEasyPage01.showMessageButton.click();
        Assert.assertEquals(selEasyPage01.yourMessage.getText(),"Hallo");
        Assert.assertTrue(selEasyPage01.yourMessage.isDisplayed());

    }

    @Test
    public void TC0104() {
//        Kullanici, Two Input Fields basligi altindaki "Enter a" ve "Enter b" box'larina sayisal degerler
//        disinda karakter girdiginde ve "Get Total" butonuna tiladiginda "Total a + b = NaN" mesajini
//        almali ve bunu dogrulamalidir. Sayisal degerler girdiginde "Total a + b = ..." girdigi rakamlarin
//        toplamini almali ve bunu dogrulayabilmelidir.
        selEasyPage01.startPracticing.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage01.simpleFormDemoLink.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        selEasyPage01.sum1.sendKeys("5");
        ReusableMethods.waitFor(1);
        selEasyPage01.sum2.sendKeys("4");
        selEasyPage01.getTotalButton.click();
        Assert.assertEquals(selEasyPage01.displayTotalValue.getText(),"9");
        Assert.assertTrue(selEasyPage01.displayTotalValue.isDisplayed());




    }

}


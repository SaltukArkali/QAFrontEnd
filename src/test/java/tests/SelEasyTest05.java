package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SelEasyPage04;
import pages.SelEasyPage05;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class SelEasyTest05 {

    SelEasyPage05 selEasyPage05 = new SelEasyPage05();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeMethod
    public void before() {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasy"));
        ReusableMethods.waitFor(1);
        try {
            selEasyPage05.closeSign.click();
        } catch (Exception ignored) {
        }
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage05.startPracticing.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage05.intermediateLink.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage05.intermediateLink.click();
    }

    @Test
    public void TC0501() {
//        Kullanici, INTERMEDIATE ==> "JQuery List Box" linkine tiklar ve 'Pick List" panelinde bulunan
//        'Valentina', 'Giovanna', 'Helena', 'Lara' ve 'Julia' option'larini alarak, sag panele ekler ve
//        sol panelde 10 options, sag panelde de 5 options oldugunu dogrular.

        selEasyPage05.jqueryListBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);

        Select select1=new Select(selEasyPage05.pickListSelect);
        System.out.println(select1.getOptions().size());
        select1.selectByVisibleText("Valentina");
        selEasyPage05.addButton.click();
        select1.selectByVisibleText("Giovanna");
        selEasyPage05.addButton.click();
        select1.selectByVisibleText("Helena");
        selEasyPage05.addButton.click();
        select1.selectByVisibleText("Lara");
        selEasyPage05.addButton.click();
        select1.selectByVisibleText("Julia");
        selEasyPage05.addButton.click();

        Select select2 = new Select(selEasyPage05.controlListSelect);
        System.out.println(select1.getOptions().size());
        System.out.println(select2.getOptions().size());
        Assert.assertTrue(select1.getOptions().size()==10 && select2.getOptions().size()==5);

    }

    @Test
    public void TC0502() {
//        Kullanici, INTERMEDIATE ==> "Data List Filter" linkine tikladiktan sonra  acilan sayfada herbir kisiye
//        ait Email adresinin oldugunu ve 'Search Attendees...' search box'ina  "Brian Hoyies" yazdiginda
//        sayfada sadece O'na ait bilgilerin kaldigini dogrular.
        selEasyPage05.dataListFilter.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);

        List<String> emailListe = ReusableMethods.getElementsText(selEasyPage05.emailList);
        System.out.println(emailListe);
        System.out.println(emailListe.size());
        for (int i =0;i<emailListe.size();i++) {
            Assert.assertTrue(selEasyPage05.emailList.get(i).isDisplayed());
            ReusableMethods.waitFor(1);
        }
        ReusableMethods.waitFor(1);
        selEasyPage05.searchAttendees.sendKeys("Brian Hoyies");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(selEasyPage05.nameBrian.isDisplayed());

    }

    @Test
    public void TC0503() {
//        Kullanici, INTERMEDIATE ==> File Download linkine tiklar. 'Enter Data' textarea'ya
//        "Selenium practice yapiyorum!" seklinde yazdiginda textarea'nin hemen altindaki satirda
//        472 karekter daha kaldigini dogrular.
//        'Generate File' butonuna tikladiktan sonra cikan 'Download' linkine tiklar.
//        "Selenium practice yapiyorum!" cumlesinin download edildigini dogrular.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage05.fileDownload.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);

        selEasyPage05.enterDataText.sendKeys("Selenium practice yapiyorum!");
        ReusableMethods.waitFor(1);
        Assert.assertTrue(selEasyPage05.feedbackText.getText().equals("472 characters remaining"));

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}




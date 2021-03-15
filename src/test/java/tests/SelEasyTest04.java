package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SelEasyPage03;
import pages.SelEasyPage04;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class SelEasyTest04 {

    SelEasyPage04 selEasyPage04 = new SelEasyPage04();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeMethod
    public void before() {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasy"));
        ReusableMethods.waitFor(1);
        try {
            selEasyPage04.closeSign.click();
        } catch (Exception ignored) {
        }
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage04.startPracticing.click();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage04.intermediateLink.click();
    }

    @Test
    public void TC0401() {
//        Kullanici, INTERMEDIATE basliginin altinda bulunan "Ajax Form Submit" linkine tiklar ve
//           'Ajax Form" bolumunde bulunan Name ve Comment input'larini doldurup Submit butonuna
//        tikladiktan sonra "Form submited Successfully!" mesajini aldigini dogrular.
        selEasyPage04.ajaxFormSubmit.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage04.nameFormBoxText.sendKeys("Saltuk");
        ReusableMethods.waitFor(1);
        selEasyPage04.commentBoxText.sendKeys("still coding");
        ReusableMethods.waitFor(1);
        selEasyPage04.submitButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(selEasyPage04.confirmBoxText.getText().equals("Form submited Successfully!"));
    }

    @Test
    public void TC0402() {
//        Kullanici, INTERMEDIATE basliginin altinda bulunan "JQuery Select dropdown" linkine tiklar ve
//                sirasiyla
//        1)Select Country : dropDown kisminda 'United States of America',
//                2)Select State : kisminda 'Michigan' eyaletini,
//                3)Select US Outlying Territories : kisminda 'Virgin Islands' ve
//        4)'Select a file' dropDown'da 'Java' yi secer.
//        herbirinin gorundugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage04.jquerySelectDropdown.click();
        ReusableMethods.waitFor(1);
        Select select = new Select(selEasyPage04.selectCountry);
        select.selectByValue("United States of America");
        actions.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"United States of America");

        select = new Select(selEasyPage04.selectState);
        select.selectByVisibleText("Michigan");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Michigan");

        select = new Select(selEasyPage04.selectUSOutlyingTerritories);
        select.selectByIndex(5);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Virgin Islands");

        select = new Select(selEasyPage04.selectAFile);
        select.selectByVisibleText("Java");
        ReusableMethods.waitFor(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Java");
    }
    @Test
    public void TC0403() {
        selEasyPage04.bootstrapLink.click();

        selEasyPage04.selectItem("bootstrap-duallist");
        selEasyPage04.moveToRight.click();
        selEasyPage04.selectAllCheckBox.get(1).click();
        selEasyPage04.selectAllCheckBox.get(1).click();

        selEasyPage04.selectItem("Cras justo odio");
        selEasyPage04.moveToLeft.click();

        List<String> allElementText = ReusableMethods.getElementsText(selEasyPage04.allItems);

        Assert.assertTrue(allElementText.indexOf("bootstrap-duallist") >= 5);
        Assert.assertTrue(allElementText.indexOf("Cras justo odio") <= 5);
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}




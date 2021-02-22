package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SelEasyPage02;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelEasyTest02 {

    SelEasyPage02 selEasyPage02 = new SelEasyPage02();
    Actions actions = new Actions(Driver.getDriver());
    Robot r = new Robot();
    List<String> days = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));
    List<String> states = new ArrayList<>(Arrays.asList("California", "Florida", "New Jersey", "New York", "Ohio", "Texas", "Pennsylvania","Washington"));

    public SelEasyTest02() throws AWTException {
    }
    @BeforeMethod
    public void before() {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasy"));
        ReusableMethods.waitFor(1);
    }

    public void entrance() {
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage02.startPracticing.click();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage02.selectDropdownListLink.click();
        ReusableMethods.waitFor(1);
    }

    @Test
    public void TC0201() {
        if (selEasyPage02.closeSign.isDisplayed()) {
            selEasyPage02.closeSign.click();
        }
        entrance();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(selEasyPage02.dropdownText.getText().contains("1. Single Select and 2. Multi Select"));
    }

    @Test
    public void TC0202() {
        entrance();
        Select select = new Select(selEasyPage02.dropdownListDemo);
        for (int i = 1; i <= days.size(); i++) {
            ReusableMethods.waitFor(1);
            select.selectByIndex(i);
            System.out.println(days.get(i - 1));
            Assert.assertTrue(selEasyPage02.dropdownListDemo.getText().contains(days.get(i - 1)));
        }
        ReusableMethods.waitFor(2);
        select.selectByVisibleText("Friday");
        ReusableMethods.waitFor(1);
        Assert.assertTrue(selEasyPage02.daySelectedMessage.isDisplayed());
    }

    @Test
    public void TC0203() {
        entrance();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Select select = new Select(selEasyPage02.multiSelectList);
        int i = 2;
        select.selectByIndex(i);
        r.keyPress(KeyEvent.VK_CONTROL);
        select.selectByIndex(i+3);
        select.selectByIndex(i-1);
        ReusableMethods.waitFor(1);
        r.keyRelease(KeyEvent.VK_CONTROL);
        System.out.println("First clicked state : " + states.get(i));
        selEasyPage02.firstSelectedButton.click();
        ReusableMethods.waitFor(2);
        System.out.println(selEasyPage02.textStatesLink.getText());
    //    Assert.assertTrue(selEasyPage02.textStatesLink.getText().contains(states.get(i)));
    }

    @Test
    public void TC0204() {
        entrance();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Select select = new Select(selEasyPage02.multiSelectList);
        int i = 4;
        select.selectByIndex(i);
        r.keyPress(KeyEvent.VK_CONTROL);
        select.selectByIndex(i+2);
        select.selectByIndex(i-1);
        ReusableMethods.waitFor(1);
        r.keyRelease(KeyEvent.VK_CONTROL);
        selEasyPage02.getAllSelectedButton.click();
        ReusableMethods.waitFor(2);
        System.out.println(selEasyPage02.textStatesLink.getText());
   //     Assert.assertTrue(selEasyPage02.textStatesLink.getText().);

    }
}

//TC0201	"The user clicks on ""Start Practicing""
//          The user clicks on ""Select Dropdown List"""
//TC0202	Kullanici, Select List Demo basligi altindaki "Select a day (select one):" dropDown'dan tum gunleri secebildilgini dogrulamalidir. Son olarak 'Friday' secip  'Day selected :- Friday'  yazisi goruldugu dogrulanmalidir.
//TC0203	"Kullanici, Multi Select List Demo basligi altinda birden fazla eyalet sectiginde ve
//'First Selected' butonuna tikladiginda eyalet kutucugunun altinda bulunan
//""First selected option is :""  yazisinin devaminda tikladigi ilk eyaletin isminin yazili oldugunu
//dogrulamalidir."
//TC0204	"Kullanici, Multi Select List Demo basligi altinda tum eyaletleri sectikten sonra ""Get All Selected""
//butonuna tikladiginda tum eyaletlerin 'Options selected are :' yazisinin devaminda secili
//oldugunu gormelidir."

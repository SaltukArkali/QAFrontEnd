package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SelEasyPage07;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Map;

public class SelEasyTest07 {

    SelEasyPage07 selEasyPage07 = new SelEasyPage07();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeMethod
    public void before() {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasy"));
        ReusableMethods.waitFor(1);
        try {
            selEasyPage07.closeSign.click();
        } catch (Exception ignored) {
        }
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage07.startPracticing.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage07.advancedLink.click();
    }
    @Test
    public void TC0701() {
//        Kullanici, Advanced ==> "Table Filter" linkine tiklar ve 'Filter Records' basligi altindaki conteynir'da toplam
//        5 tane element bulundugunu "Orange" butonuna tikladiktan sonra  2 element kaldigini assert eder.
        selEasyPage07.tableFilter.click();
        int elemanSayisi = selEasyPage07.elementList.size();
        Assert.assertTrue(elemanSayisi==5);
        ReusableMethods.waitFor(1);
        selEasyPage07.orangeButton.click();
        int count=0;
        for (WebElement w:selEasyPage07.elementList) {
            if(w.isDisplayed()){
                count++;
            }
        }
        System.out.println("Displayed Elements : "+count);
        Assert.assertTrue(count==2);
    }

    @Test
    public void TC0702() {
//        Kullanici, Advanced ==>  "Table Sort & Search" linkine tikladiktan sonra  acilan sayfada toplam 32
//        kisiye ait bilgi oldugunu ve en altta "Showing 1 to 32 of 32 entries" yazisini dogrular.
        selEasyPage07.tableSortSearch.click();
        int sum =0;
        int page1 = selEasyPage07.listOfItemsPerPage.size();
        selEasyPage07.page2.click();
        int page2 = selEasyPage07.listOfItemsPerPage.size();
        selEasyPage07.page3.click();
        int page3 = selEasyPage07.listOfItemsPerPage.size();
        selEasyPage07.page4.click();
        int page4 = selEasyPage07.listOfItemsPerPage.size();

        sum=page1+page2+page3+page4;
        System.out.println("Toplam sayi : "+sum);
        Assert.assertTrue(sum==32);
        System.out.println(selEasyPage07.infoText.getText());
        ReusableMethods.waitFor(1);
        Assert.assertEquals(selEasyPage07.infoText.getText(),"Showing 31 to 32 of 32 entries");

    }

    @Test
    public void TC0703() {
//        Kullanici, Advanced ==>  "Table Sort & Search" linkine tikladiktan sonra  acilan sayfada
//        maasi(salary) 200,000 binden fazla olan olan 18 kisinin oldugu,  4 kisinin Tokyo'da
//        calistigini dogrular. Ayrica calisanlarin yas ortalamasini bulur.

        selEasyPage07.tableSortSearch.click();
        Select select=new Select(selEasyPage07.show);
        select.selectByValue("100");
        ReusableMethods.waitFor(1);

        int sum = selEasyPage07.listOfItemsPerPage.size();
        System.out.println("Toplam sayi : "+sum);

        for (WebElement w:selEasyPage07.listOfSalary) {
            System.out.println(w.getAttribute("data-order"));
        }


    }

//    @AfterClass
//    public void tearDown() {
//        Driver.closeDriver();
//    }
}




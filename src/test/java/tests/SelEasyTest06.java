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
import pages.SelEasyPage05;
import pages.SelEasyPage06;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelEasyTest06 {

    SelEasyPage06 selEasyPage06 = new SelEasyPage06();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeMethod
    public void before() {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasy"));
        ReusableMethods.waitFor(1);
        try {
            selEasyPage06.closeSign.click();
        } catch (Exception ignored) {
        }
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        selEasyPage06.startPracticing.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        selEasyPage06.advancedLink.click();
    }
    @Test
    public void TC0601() {
//        Kullanici, Advanced ==> "Table Pagination" linkine tiklar ve toplam 3(uc) sayfa link oldugunu ve
//        ileri geri play linklerinin calistigini  dogrular. Toplam 78 tane cell oldugunu assert ediniz.
        selEasyPage06.tablePagination.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        int numPage=selEasyPage06.listPage.size()+1;
        System.out.println("sayfa sayisi : " + numPage);
        Assert.assertTrue(numPage==3);

        String before=selEasyPage06.page2.getCssValue("background-color");
        System.out.println(before);

        selEasyPage06.nextLink.click();
        ReusableMethods.waitFor(1);
        String after = selEasyPage06.page2.getCssValue("background-color");
        System.out.println(after);

        if(after=="rgba(51, 122, 183, 1)"){
            Assert.assertTrue(2==2);
        }else if(after=="rgba(255, 255, 255, 1)"){
            Assert.assertFalse(2==2);
        }
        String pageActive=selEasyPage06.page2.getText();
        System.out.println(pageActive);

        int listSize = selEasyPage06.tableCellList.size();
        System.out.println(listSize);
        Assert.assertTrue(listSize==78);

    }

    @Test
    public void TC0602() {
//        Kullanici, Advanced ==>  "Table Data Search" linkine tikladiktan sonra  acilan sayfada
//        'Tasks' panelinin altinda "#", "Task", "Assignee", "Status" basliklarinin oldugunu dogrular.
//                Input'ta (filter box)  "Filter by Task / Assignee / Status " textinin  yer aldigini ve input'a "Mike"
//        yazdiginda ekranda sadece Mike Trout'a ait satirin kaldigi assert eder.
        selEasyPage06.tableDataSearch.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        List<String> headerExpectedList = Arrays.asList(new String[]{"#", "Task", "Assignee", "Status"});

        System.out.println(selEasyPage06.headerList.size());
        int i=0;
        for (WebElement header:selEasyPage06.headerList) {
            System.out.println(header.getText());
            Assert.assertEquals(header.getText(),headerExpectedList.get(i));
            i++;
        }

        System.out.println(selEasyPage06.textBox.getText());
        selEasyPage06.textBox.sendKeys("Mike");
        Assert.assertEquals(selEasyPage06.selectedPerson.getText(),"Mike Trout");

    }

    @Test
    public void TC0603() {
//        Kullanici, Advanced ==> "Table Data Search" linkine tikladiktan sonra acilan sayfada 'Listed Users'
//        panelinin aldindaki dort(4) tane input'un aktif olmadigini, 'Filter' butonuna tikladiktan sonra
//        bu input box'larin aktiflestigini dogrular.
//        'FirstName' input box'ina "B" karakteri girildiginde panelde sadece "Brigade" ve "Byron" isimlerine
//        ait bilgilerin kaldigi assert edilmelidir.
        selEasyPage06.tableDataSearch.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        for (WebElement w:selEasyPage06.boxList){
            Assert.assertTrue(w.isDisplayed());
            Assert.assertFalse(w.isEnabled());
        }
        selEasyPage06.filterButton.click();
        for (WebElement w:selEasyPage06.boxList){
            Assert.assertFalse(w.isDisplayed());
            Assert.assertTrue(w.isEnabled());
        }
        ReusableMethods.waitFor(2);
        selEasyPage06.firstNameBox.sendKeys("B");

        for(WebElement w:selEasyPage06.listedUsers){
            if(w.isDisplayed()){
                System.out.println(w.getText());
                Assert.assertTrue(w.getText().contains("Brigade") || w.getText().contains("Byron"));
            }
        }


    }

//    @AfterClass
//    public void tearDown() {
//        Driver.closeDriver();
//    }
}




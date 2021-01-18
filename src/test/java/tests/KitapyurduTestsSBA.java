package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KitapyurduPagesSBA;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class KitapyurduTestsSBA {

    KitapyurduPagesSBA pages = new KitapyurduPagesSBA();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void deneme(){
        Driver.getDriver().get(ConfigReader.getProperty("google"));
        ReusableMethods.waitFor(5);
        Driver.getDriver().switchTo().frame(0);
        pages.ichStimmeZu.click();
        pages.searchBox.sendKeys("kitap yurdu"+ Keys.ENTER);
        ReusableMethods.waitFor(4);
        pages.kitapYurduLink.click();
        ReusableMethods.waitFor(2);

        String title = Driver.getDriver().getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Kitapyurdu, Kitapla buluşmanın en kolay yolu");

        pages.sepetLink.click();
        ReusableMethods.waitFor(2);
        String sepetAciklama = pages.sepetAciklama.getText();
        System.out.println(sepetAciklama);
        Assert.assertEquals(sepetAciklama,"Alışveriş sepetiniz boş!");

        pages.enCokSatanLink.click();
        ReusableMethods.waitFor(1);
        pages.kitapEnCokSatan.click();
        ReusableMethods.waitFor(2);

        for(int i=0;i<10;i++) {
            String bookName = pages.cokSatanList.get(i).getText();
            System.out.println(bookName);
        }

        String enCokSatanKitap = pages.cokSatanList.get(0).getText();
        System.out.println(enCokSatanKitap);
        Assert.assertTrue(enCokSatanKitap.contains("Körlük"));

        pages.alertIgnore.click();
        ReusableMethods.waitFor(2);

        pages.searchBoxAbove.sendKeys("suç ve ceza"+Keys.ENTER);
        ReusableMethods.waitFor(3);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        Assert.assertEquals(pages.sucVeCeza1.getText(),"Suç ve Ceza 1");
        ReusableMethods.waitFor(3);
        Assert.assertEquals(pages.sucVeCeza2.getText(),"Suç ve Ceza 2");

         ReusableMethods.waitFor(1);
//        String abc = pages.sucVeCeza1Fiyat.getAttribute("/span");
//        System.out.println(abc);
////        Assert.assertEquals(pages.sucVeCeza1Fiyat.getText(),"9.00");
////        ReusableMethods.waitFor(1);
////        Assert.assertEquals(pages.sucVeCeza2Fiyat.getText(),"7.49");

        pages.sepeteEkle12.click();
        ReusableMethods.waitFor(2);
        pages.sepeteEkle14.click();
        ReusableMethods.waitFor(2);

        pages.sepet.click();
        String sepetAyrinti = pages.sepetIcerik.getText();
        System.out.println(sepetAyrinti);
        Assert.assertTrue(sepetAyrinti.contains("Suç ve Ceza 1"));
        Assert.assertTrue(sepetAyrinti.contains("Suç ve Ceza 2"));

    }

}

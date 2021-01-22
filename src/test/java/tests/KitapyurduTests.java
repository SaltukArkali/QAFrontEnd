package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KitapyurduPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class KitapyurduTests {

    KitapyurduPages pages = new KitapyurduPages();
    Actions actions = new Actions(Driver.getDriver());

    //    @Test
//    public void beforeMethod(){
//        Driver.getDriver().get(ConfigReader.getProperty("google"));
//        ReusableMethods.waitFor(5);
//        Driver.getDriver().switchTo().frame(0);
//        pages.ichStimmeZu.click();
//    }
    @Test
    public void TC01(){
        Driver.getDriver().get(ConfigReader.getProperty("google"));
        ReusableMethods.waitFor(5);
        Driver.getDriver().switchTo().frame(0);
        pages.ichStimmeZu.click();
        pages.googleSearchBox.sendKeys("kitap yurdu");
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Test
    public void TC02(){
        Driver.getDriver().get(ConfigReader.getProperty("google"));
//        ReusableMethods.waitFor(5);
//        Driver.getDriver().switchTo().frame(0);
//        pages.ichStimmeZu.click();
        pages.googleSearchBox.sendKeys("kitap yurdu");
        actions.sendKeys(Keys.ENTER).perform();
        pages.firstSearchResult.click();
    }
    @Test
    public void TC03(){
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurdu"));
        Assert.assertEquals(Driver.getDriver().getTitle(),
                "Kitapyurdu, Kitapla buluşmanın en kolay yolu");
    }
    @Test
    public void TC04(){
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurdu"));
        pages.myBag.click();
        Assert.assertEquals(pages.myBackCard.getText(),"Alışveriş sepetiniz boş!");
    }
    @Test
    public void TC05(){
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurdu"));
        for(int i=0;i<10;i++){
            System.out.println(pages.bestSeller.get(i).getText());
        }
    }
    @Test
    public void TC06(){
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurdu"));
        Assert.assertEquals(pages.bestSeller.get(0).getText(),"Körlük");
    }
    @Test
    public void TC07(){
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurdu"));
        pages.searchBox.sendKeys("suç ve ceza");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        pages.sucVeCeza1.click();
        Assert.assertEquals(pages.productPrice.getText(),"9,00");
        Driver.getDriver().navigate().back();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pages.sucVeCeza2.click();
        Assert.assertEquals(pages.productPrice.getText(),"7,49");
    }
    @Test
    public void TC08(){
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurdu"));
        pages.searchBox.sendKeys("suç ve ceza");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        pages.sucVeCeza1.click();
        pages.addToBag.click();
        Driver.getDriver().navigate().back();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pages.sucVeCeza2.click();
        pages.addToBag.click();
        pages.myBag.click();
        for(WebElement w : pages.listOfBooksInBag){
            System.out.println(w.getText());
        }
    }

}
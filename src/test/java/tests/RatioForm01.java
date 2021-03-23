package tests;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.codehaus.groovy.ast.stmt.TryCatchStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class RatioForm01 {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("ratioForm"));
        ReusableMethods.waitFor(1);
        WebElement closeSign = Driver.getDriver().findElement(By.id("close-cookie"));
        try {
            closeSign.click();
        } catch (Exception ignored) {
        }
        ReusableMethods.waitFor(1);
        WebElement suchen = Driver.getDriver().findElement(By.xpath("(//input[@data-mobile-placeholder='Suchen'])[1]"));
        suchen.sendKeys("Wellpapp");
        ReusableMethods.waitFor(1);
        WebElement firstSearchOption = Driver.getDriver().findElement(By.xpath("(//div[@class='suggestion-product'])[1]"));
        firstSearchOption.click();

        WebElement productName = Driver.getDriver().findElement(By.xpath("//h1[@itemprop='name']"));
        System.out.println("Product Name : " +productName.getText());
        Assert.assertTrue(productName.isDisplayed());


    }

}

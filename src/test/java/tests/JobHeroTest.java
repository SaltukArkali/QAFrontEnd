package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.JobHeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class JobHeroTest {

    JobHeroPage jobHeroPage = new JobHeroPage();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void tc01(){
        Driver.getDriver().get(ConfigReader.getProperty("jobhero"));
        ReusableMethods.waitFor(2);

        Select se = new Select(jobHeroPage.resumeLink);
        se.selectByIndex(0);
        actions.sendKeys(Keys.ENTER);




    }




}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Way2AutomationPage {

    public Way2AutomationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='Signin']")
    public WebElement signInLink;
    @FindBy(xpath = "(//input[@name='username'])[2]")
    public WebElement username;
    @FindBy(xpath = "(//input[@name='password'])[2]")
    public WebElement password;
    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public  WebElement submitButton;
    @FindBy(xpath = "//h2[.='Draggable']")
    public WebElement draggableLink;
    @FindBy(xpath = "(//html/body/div[@id='draggable'])[1]")//  "
    public WebElement draggableBox;


}

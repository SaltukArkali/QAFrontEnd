package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SelEasyPage01 {

    public SelEasyPage01(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement closeSign;

    @FindBy(id = "btn_basic_example")
    public WebElement startPracticing;

    @FindBy(xpath = "(//a[@class='list-group-item'])[1]")
    public WebElement simpleFormDemoLink;

    @FindBy(id = "user-message")
    public WebElement enterMessageBox;

    @FindBy(xpath = "//button[@onclick='showInput();']")
    public WebElement showMessageButton;

    @FindBy(id = "display")
    public WebElement yourMessage;

    @FindBy(id = "sum1")
    public WebElement sum1;

    @FindBy(id = "sum2")
    public WebElement sum2;

    @FindBy(xpath = "//button[@onclick='return total()']")
    public WebElement getTotalButton;

    @FindBy(id = "displayvalue")
    public WebElement displayTotalValue;


}

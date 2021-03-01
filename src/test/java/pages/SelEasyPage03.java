package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SelEasyPage03 {

    public SelEasyPage03(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement closeSign;

    @FindBy(id = "btn_basic_example")
    public WebElement startPracticing;

    @FindBy(xpath = "(//a[@class='list-group-item'])[5]")
    public WebElement javascrıptAlertsLink;

    @FindBy(xpath = "//*[.='JavaScript has three kind of popup boxes: Alert box, Confirm box, and Prompt box.']")
    public WebElement mainText;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    public WebElement alertBoxButton;

    @FindBy(xpath = "(//button[@class='btn btn-default btn-lg'])[1]")
    public WebElement confirmBoxButton;

    @FindBy(id = "confirm-demo")
    public WebElement confirmBoxText;

    @FindBy(xpath = "(//button[@class='btn btn-default btn-lg'])[2]")
    public WebElement alertBoxPromptButton;

    @FindBy(id = "prompt-demo")
    public WebElement promptBoxText;

}

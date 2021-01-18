package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Way2AutomationPage {

    public Way2AutomationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
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


    // Droppable

    // Resizable

    @FindBy(xpath = "//h2[.='Resizable']")
    public WebElement resizableLink;
    @FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
    public List<WebElement> cursorResizable;
    @FindBy(xpath = "(//div[@id='resizable'])[1]")
    public WebElement getResizableValue;

    // Selectable

    @FindBy(xpath = "//li[@class='ui-widget-content ui-selectee']")
    public List<WebElement> selectFirstList;

    @FindBy(xpath = "//h2[.='Selectable']")
    public WebElement selectableLink;

    @FindBy(xpath = "//*[.='Display as grid']")
    public WebElement displayAsGridLink;

    @FindBy(xpath = "//li[@class='ui-state-default ui-selectee']")
    public List<WebElement> selectSecondList;

    @FindBy(xpath = "//*[.='Serialize']")
    public WebElement serializeLink;

    @FindBy(xpath = "//li[@class='ui-widget-content ui-selectee']")
    public List<WebElement> selectThirdList;

    @FindBy(xpath = "//*[.='You've selected:']")
    public WebElement serializeTextLink;

    @FindBy(id = "select-result")
    public WebElement itemNo;

    @FindBy(xpath = "//p[@id='feedback']")
    public WebElement feedbackText;


}

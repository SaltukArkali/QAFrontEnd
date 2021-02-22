package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SelEasyPage02 {

    public SelEasyPage02(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement closeSign;

    @FindBy(id = "btn_basic_example")
    public WebElement startPracticing;

    @FindBy(xpath = "(//a[@class='list-group-item'])[4]")
    public WebElement selectDropdownListLink;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/p")
    public WebElement dropdownText;

    @FindBy(id = "select-demo")
    public WebElement dropdownListDemo;

    @FindBy(xpath = "//p[.='Day selected :- Friday']")
    public WebElement daySelectedMessage;

    @FindBy(id = "multi-select")
    public WebElement multiSelectList;

    @FindBy(id = "printMe")
    public WebElement firstSelectedButton;

    @FindBy(id = "printAll")
    public WebElement getAllSelectedButton;

    @FindBy(className = "getall-selected")
    public WebElement textStatesLink;
}
